package com.laiteam.echowall.ui.onboarding

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.R
import com.laiteam.echowall.base.BaseActivity
import com.laiteam.echowall.databinding.ActivityOnBoardingBinding
import com.laiteam.echowall.di.activity.OnBoardingComponent

class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>() {
    lateinit var onBoardingComponent: OnBoardingComponent

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        onBoardingComponent = app.appComponent.onBoardingComponent().create()
        onBoardingComponent.inject(this)
        super.onCreate(savedInstanceState)
    }


    override fun initViews() {
        super.initViews()
        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun createViewBinding(): ActivityOnBoardingBinding {
        return ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}