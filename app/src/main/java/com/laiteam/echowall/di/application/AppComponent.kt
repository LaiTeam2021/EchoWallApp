package com.laiteam.echowall.di.application

import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.network.NetworkModule
import com.laiteam.echowall.sharedpreference.AppStorageModule
import com.laiteam.echowall.user.UserManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppStorageModule::class, NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(module: AppModule): AppComponent
    }

    fun userManager(): UserManager

    fun userComponent(): UserComponent.Factory

    fun activityComponent(): ActivityComponent.Factory

}