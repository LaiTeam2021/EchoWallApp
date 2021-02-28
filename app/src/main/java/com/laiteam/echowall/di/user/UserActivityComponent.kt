package com.laiteam.echowall.di.user

import com.laiteam.echowall.di.scope.ActivityScope
import com.laiteam.echowall.di.viewmodel.UserViewModelModule
import com.laiteam.echowall.ui.feed.FeedFragment
import com.laiteam.echowall.ui.main.MainActivity
import com.laiteam.echowall.ui.me.debug.DebugFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [UserViewModelModule::class]
)
interface UserActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): UserActivityComponent
    }

    fun inject(activity: MainActivity)

    fun inject(fragment: FeedFragment)
    fun inject(fragment: DebugFragment)
}