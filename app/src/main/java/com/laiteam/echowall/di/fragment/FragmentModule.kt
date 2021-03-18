package com.laiteam.echowall.di.fragment

import androidx.fragment.app.Fragment
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.sharedpreference.AppSharedPreferencesStorage
import com.laiteam.echowall.sharedpreference.Storage
import com.laiteam.echowall.ui.navigator.FragmentNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    fun providerFragment(): Fragment {
        return fragment
    }

    @Provides
    fun provideNavigator(): Navigator {
        return FragmentNavigator(fragment)
    }
}