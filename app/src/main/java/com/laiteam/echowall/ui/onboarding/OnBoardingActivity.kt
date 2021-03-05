package com.laiteam.echowall.ui.onboarding

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseActivity
import com.laiteam.echowall.databinding.ActivityOnBoardingBinding
import com.laiteam.echowall.di.activity.ActivityComponent

class OnBoardingActivity : DaggerBaseActivity<ActivityOnBoardingBinding>() {
    private lateinit var navController: NavController

    override fun initViews() {
        super.initViews()
        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun createViewBinding(): ActivityOnBoardingBinding {
        return ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun setupActivityScopeInject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}