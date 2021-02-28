package com.laiteam.echowall.network

import androidx.lifecycle.LiveData
import com.laiteam.echowall.network.model.SeverInfo
import com.laiteam.echowall.network.response.ApiResponse
import retrofit2.http.GET

interface Api {

    //TODO("add server https://api.developerforfun.com/)

    @GET("environment")
    fun getServerInfo(): LiveData<ApiResponse<SeverInfo>>
}