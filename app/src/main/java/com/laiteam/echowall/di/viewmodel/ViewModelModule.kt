package com.laiteam.echowall.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.laiteam.echowall.mvvm.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(FeedViewModel::class)
//    internal abstract fun feedViewModel(viewModel: FeedViewModel): ViewModel

    //Add more ViewModels here

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}