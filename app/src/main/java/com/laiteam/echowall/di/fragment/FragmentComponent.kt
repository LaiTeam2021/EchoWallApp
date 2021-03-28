package com.laiteam.echowall.di.fragment

import com.laiteam.echowall.ui.feed.FeedFragment
import com.laiteam.echowall.ui.main.MainFragment
import com.laiteam.echowall.ui.me.MeFragment
import com.laiteam.echowall.ui.me.debug.DebugFragment
import com.laiteam.echowall.ui.notification.NotificationFragment
import com.laiteam.echowall.ui.notification.NotificationTabFragment
import dagger.Subcomponent

@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(module: FragmentModule): FragmentComponent
    }

    fun inject(fragment: FeedFragment)
    fun inject(fragment: DebugFragment)
    fun inject(fragment: MainFragment)
    fun inject(fragment: MeFragment)
    fun inject(fragment: NotificationFragment)
    fun inject(fragment: NotificationTabFragment)
}