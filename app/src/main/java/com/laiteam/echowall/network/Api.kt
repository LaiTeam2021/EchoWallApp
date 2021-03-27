package com.laiteam.echowall.network

import androidx.lifecycle.LiveData
import com.laiteam.echowall.network.response.LoginResponse
import com.laiteam.echowall.network.request.LoginRequestBody
import com.laiteam.echowall.network.response.SeverResponse
import com.laiteam.echowall.network.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    //TODO("add server https://api.developerforfun.com/)

    @GET("environment")
    fun getServerInfo(): LiveData<ApiResponse<SeverResponse>>

    @POST("users/login")
    fun login(@Body loginRequesBody: LoginRequestBody): LiveData<ApiResponse<LoginResponse>>
}