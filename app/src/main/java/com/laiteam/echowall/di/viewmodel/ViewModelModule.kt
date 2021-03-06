package com.laiteam.echowall.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laiteam.echowall.mvvm.ViewModelFactory
import com.laiteam.echowall.ui.me.debug.DebugViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DebugViewModel::class)
    internal abstract fun debugViewModel(viewModel: DebugViewModel): ViewModel

    //Add more ViewModels here

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
