package com.laiteam.echowall.di.fragment

import com.laiteam.echowall.ui.feed.FeedFragment
import com.laiteam.echowall.ui.me.debug.DebugFragment
import dagger.Subcomponent

@Subcomponent
interface FragmentComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentComponent
    }

    fun inject(fragment: FeedFragment)
    fun inject(fragment: DebugFragment)
}