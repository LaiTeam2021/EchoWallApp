package com.laiteam.echowall.network

import android.app.Application
import com.android.example.github.util.LiveDataCallAdapterFactory
import com.ashokvarma.gander.GanderInterceptor
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
    fun provideRestAdapter(app: App, context: Application): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(GanderInterceptor(context).showNotification(true))
                .addNetworkInterceptor(FlipperOkhttpInterceptor(app.networkFlipperPlugin))
                .build()
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}