package com.laiteam.echowall.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseActivity
import com.laiteam.echowall.databinding.ActivityMainBinding
import com.laiteam.echowall.di.user.ActivityComponent


class MainActivity : DaggerBaseActivity<ActivityMainBinding>() {
    lateinit var navHostFragment: NavHostFragment
    override fun initViews() {
        navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.findNavController().setGraph(R.navigation
                .main_nav_graph)
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}