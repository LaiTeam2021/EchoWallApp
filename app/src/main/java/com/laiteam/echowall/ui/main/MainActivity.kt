package com.laiteam.echowall.ui.main

import android.content.res.Configuration
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseUserActivity
import com.laiteam.echowall.databinding.ActivityMainBinding
import com.laiteam.echowall.di.activity.ActivityComponent
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity

class MainActivity : DaggerBaseUserActivity<ActivityMainBinding>() {
    override fun initViews() {
        super.initViews()
        binding.logout.setOnClickListener {
            if (userManager.onUserLogout()) {
                startActivityAfterFinishThis(OnBoardingActivity::class.java)
            }
        }
        binding.mainViewpager.adapter = MainViewPagerAdapter(this)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {it ->
            when(it.itemId) {
                R.id.feed -> {
                    binding.mainViewpager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.explore -> {
                    binding.mainViewpager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.notification -> {
                    binding.mainViewpager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.me -> {
                    binding.mainViewpager.currentItem = 3
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun setupInjection(userActivityComponent: UserActivityComponent) {
         userActivityComponent.inject(this)
    }
}