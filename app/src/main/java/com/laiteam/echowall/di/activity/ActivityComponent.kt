package com.laiteam.echowall.di.activity

import com.laiteam.echowall.di.scope.ActivityScope
import com.laiteam.echowall.di.viewmodel.ViewModelModule
import com.laiteam.echowall.ui.main.MainActivity
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity
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

    fun inject(activity: OnBoardingActivity)
}