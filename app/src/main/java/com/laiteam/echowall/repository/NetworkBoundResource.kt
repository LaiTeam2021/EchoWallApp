/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.laiteam.echowall.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.laiteam.echowall.network.response.ApiErrorResponse
import com.laiteam.echowall.network.response.ApiResponse
import com.laiteam.echowall.network.response.ApiSuccessResponse
import com.laiteam.echowall.network.response.NetworkResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 *
 * You can read more about it in the [Architecture
 * Guide](https://developer.android.com/arch).
 * @param <ResultType> The data format consumed by UI
 * @param <RequestType> The data format api emits
</RequestType></ResultType> */
abstract class NetworkBoundResource<ResultType, RequestType>
@MainThread constructor(val coroutineJob: Job) {

    private val result = MediatorLiveData<NetworkResponse<ResultType>>()

    private fun initialize() {
        result.value = NetworkResponse.loading(null)
        val dbSource = loadFromDb()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    setValue(NetworkResponse.success(newData))
                }
            }
        }
    }

    @MainThread
    private fun setValue(newValue: NetworkResponse<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(dbSource) { newData ->
            setValue(NetworkResponse.loading(newData))
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response) {
                is ApiSuccessResponse -> {
                    if (shouldSave(response.body)) {
                        CoroutineScope(Dispatchers.IO + coroutineJob).launch {
                            saveResponse(response.body)
                            CoroutineScope(Dispatchers.Main + coroutineJob).launch {
                                result.addSource(loadFromDb()) { newData ->
                                    setValue(NetworkResponse.success(newData))
                                }
                            }
                        }
                    } else {
                        setValue(NetworkResponse.success(processResponse(response.body)))
                    }


                }
                is ApiErrorResponse -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        setValue(NetworkResponse.error(response.errorMessage, newData))
                    }
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    fun asLiveData(): LiveData<NetworkResponse<ResultType>> {
        initialize()
        return result
    }

    @MainThread
    protected abstract fun processResponse(response: RequestType): ResultType

    @WorkerThread
    protected abstract suspend fun saveResponse(response: RequestType)

    @MainThread
    protected abstract fun shouldSave(data: RequestType): Boolean

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}
