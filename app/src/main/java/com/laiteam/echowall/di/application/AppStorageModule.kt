package com.laiteam.echowall.di.application

import com.laiteam.echowall.sharedpreference.AppSharedPreferencesStorage
import com.laiteam.echowall.sharedpreference.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class AppStorageModule {

    @Binds
    abstract fun provideStorage(appSharedPreferencesStorage: AppSharedPreferencesStorage): Storage
}