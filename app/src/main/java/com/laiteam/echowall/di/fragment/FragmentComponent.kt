package com.laiteam.echowall.di.fragment

import com.laiteam.echowall.ui.feed.FeedFragment
import com.laiteam.echowall.ui.main.MainFragment
import com.laiteam.echowall.ui.me.MeFragment
import com.laiteam.echowall.ui.me.debug.DebugFragment
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
}