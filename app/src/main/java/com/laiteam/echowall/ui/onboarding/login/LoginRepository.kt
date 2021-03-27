package com.laiteam.echowall.ui.onboarding.login

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseRepository
import com.laiteam.echowall.network.Api
import com.laiteam.echowall.network.model.LoginModel
import com.laiteam.echowall.network.request.LoginRequestBody
import com.laiteam.echowall.network.response.ApiResponse
import com.laiteam.echowall.network.response.LoginResponse
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.repository.NetworkBoundResource
import com.laiteam.echowall.util.AbsentLiveData
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: Api) : BaseRepository() {

    fun loadLoginInfo(loginRequestBody: LoginRequestBody): LiveData<NetworkResponse<LoginModel>> {
        return object : NetworkBoundResource<LoginModel, LoginResponse>(coroutineJob) {
            override suspend fun saveResponse(item: LoginResponse) {
            }

            override fun shouldFetch(data: LoginModel?) = true

            override fun loadFromDb() = AbsentLiveData.create<LoginModel>()

            override fun createCall(): LiveData<ApiResponse<LoginResponse>> =
                api.login(loginRequestBody)

            override fun processResponse(response: LoginResponse) =
                LoginModel(loginRequestBody.email, loginRequestBody.password, response.token)

            override fun shouldSave(data: LoginResponse) = false

        }.asLiveData()
    }
}