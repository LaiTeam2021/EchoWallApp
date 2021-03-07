package com.laiteam.echowall.ui.me.debug

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseRepository
import com.laiteam.echowall.network.Api
import com.laiteam.echowall.network.model.SeverInfo
import com.laiteam.echowall.network.response.ApiResponse
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.repository.NetworkBoundResource
import com.laiteam.echowall.util.AbsentLiveData
import javax.inject.Inject

class DebugRepository @Inject constructor(private val api: Api) : BaseRepository() {


    fun loadSeverInfo(): LiveData<NetworkResponse<SeverInfo>> {
        return object : NetworkBoundResource<SeverInfo, SeverInfo>(coroutineJob) {
            override suspend fun saveResponse(response: SeverInfo) {
            }

            override fun shouldFetch(data: SeverInfo?) = true

            override fun loadFromDb() = AbsentLiveData.create<SeverInfo>()

            override fun createCall(): LiveData<ApiResponse<SeverInfo>> = api.getServerInfo()

            override fun processResponse(response: SeverInfo) = response

            override fun shouldSave(data: SeverInfo) = false

        }.asLiveData()
    }
}