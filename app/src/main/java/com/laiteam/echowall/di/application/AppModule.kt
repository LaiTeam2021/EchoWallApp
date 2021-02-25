package com.laiteam.echowall.di.application

import android.app.Application
import com.laiteam.echowall.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {
    @Provides
    @Singleton
    fun provideApp(): App {
        return application
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }
}