package com.laiteam.echowall.ui.onboarding.login

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseRepository
import com.laiteam.echowall.network.Api
import com.laiteam.echowall.network.model.LoginInfo
import com.laiteam.echowall.network.request.LoginRequestBody
import com.laiteam.echowall.network.response.ApiResponse
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.repository.NetworkBoundResource
import com.laiteam.echowall.util.AbsentLiveData
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: Api) : BaseRepository() {

    fun loadLoginInfo(loginRequestBody: LoginRequestBody): LiveData<NetworkResponse<LoginInfo>> {
        return object : NetworkBoundResource<LoginInfo, LoginInfo>(coroutineJob) {
            override suspend fun saveResponse(item: LoginInfo) {
            }

            override fun shouldFetch(data: LoginInfo?) = true

            override fun loadFromDb() = AbsentLiveData.create<LoginInfo>()

            override fun createCall(): LiveData<ApiResponse<LoginInfo>> = api.login(loginRequestBody)

            override fun processResponse(response: LoginInfo) = response

            override fun shouldSave(data: LoginInfo) = false

        }.asLiveData()
    }
}