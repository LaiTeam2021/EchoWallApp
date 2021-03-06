package com.laiteam.echowall.di.user

import com.laiteam.echowall.di.fragment.FragmentComponent
import com.laiteam.echowall.di.scope.ActivityScope
import com.laiteam.echowall.di.viewmodel.ViewModelModule
import com.laiteam.echowall.ui.feed.FeedFragment
import com.laiteam.echowall.ui.main.MainActivity
import com.laiteam.echowall.ui.me.debug.DebugFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [ViewModelModule::class]
)
interface ActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: MainActivity)

    fun fragmentComponent(): FragmentComponent.Factory
}