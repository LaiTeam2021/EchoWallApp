package com.laiteam.echowall.di.activity

import com.laiteam.echowall.di.scope.ActivityScope
import com.laiteam.echowall.di.viewmodel.ViewModelModule
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity
import com.laiteam.echowall.ui.onboarding.login.LoginFragment
import com.laiteam.echowall.ui.onboarding.register.RegisterFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
        modules = [ViewModelModule::class]
)
interface OnBoardingComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): OnBoardingComponent
    }

    fun inject(activity: OnBoardingActivity)
    fun inject(registerFragment: RegisterFragment)
    fun inject(loginFragment: LoginFragment)
}