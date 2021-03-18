package com.laiteam.echowall.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laiteam.echowall.mvvm.ViewModelFactory
import com.laiteam.echowall.ui.me.debug.DebugViewModel
<<<<<<< HEAD
import com.laiteam.echowall.ui.onboarding.login.LoginViewModel
=======
import com.laiteam.echowall.ui.notification.all.AllViewModel
>>>>>>> combine 4 commits into 1
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DebugViewModel::class)
    internal abstract fun debugViewModel(viewModel: DebugViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AllViewModel::class)
    internal abstract fun allViewModel(viewModel: AllViewModel): ViewModel

    //Add more ViewModels here
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
