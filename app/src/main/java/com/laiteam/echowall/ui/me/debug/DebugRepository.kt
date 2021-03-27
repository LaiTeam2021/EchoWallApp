package com.laiteam.echowall.ui.me.debug

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseRepository
import com.laiteam.echowall.network.Api
import com.laiteam.echowall.network.response.SeverResponse
import com.laiteam.echowall.network.response.ApiResponse
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.repository.NetworkBoundResource
import com.laiteam.echowall.util.AbsentLiveData
import javax.inject.Inject

class DebugRepository @Inject constructor(private val api: Api) : BaseRepository() {


    fun loadSeverInfo(): LiveData<NetworkResponse<SeverResponse>> {
        return object : NetworkBoundResource<SeverResponse, SeverResponse>(coroutineJob) {
            override suspend fun saveResponse(response: SeverResponse) {
            }

            override fun shouldFetch(data: SeverResponse?) = true

            override fun loadFromDb() = AbsentLiveData.create<SeverResponse>()

            override fun createCall(): LiveData<ApiResponse<SeverResponse>> = api.getServerInfo()

            override fun processResponse(response: SeverResponse) = response

            override fun shouldSave(data: SeverResponse) = false

        }.asLiveData()
    }
}