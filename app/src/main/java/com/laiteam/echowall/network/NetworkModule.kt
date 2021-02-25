package com.laiteam.echowall.network

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.laiteam.echowall.App
import com.laiteam.echowall.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRestAdapter(app: App): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(app.networkFlipperPlugin))
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}