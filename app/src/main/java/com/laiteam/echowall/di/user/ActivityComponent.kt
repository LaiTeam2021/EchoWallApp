package com.laiteam.echowall.di.user

import com.laiteam.echowall.di.fragment.FragmentComponent
import com.laiteam.echowall.di.scope.ActivityScope
import com.laiteam.echowall.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun fragmentComponent(): FragmentComponent.Factory

    fun inject(activity: MainActivity)
}