package com.laiteam.echowall.network

import okhttp3.Interceptor
import okhttp3.Response

private val AUTHORIZATION_HEAD = "Authorization"
class NetworkInterceptor(private val networkHeaderProvider: NetworkHeaderProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original
            .newBuilder()
            .header(AUTHORIZATION_HEAD, networkHeaderProvider.token?: "")
            .build()
        return chain.proceed(request)
    }
}