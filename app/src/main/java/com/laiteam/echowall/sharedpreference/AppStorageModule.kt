package com.laiteam.echowall.sharedpreference

import dagger.Binds
import dagger.Module

@Module
abstract class AppStorageModule {

    @Binds
    abstract fun provideStorage(appSharedPreferencesStorage: AppSharedPreferencesStorage): Storage
}