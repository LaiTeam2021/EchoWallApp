package com.laiteam.echowall.ui

import com.laiteam.echowall.base.DaggerBaseUserActivity
import com.laiteam.echowall.databinding.ActivityMainBinding
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity

class MainActivity : DaggerBaseUserActivity<ActivityMainBinding>() {
    override fun initViews() {
        super.initViews()
        binding.logout.setOnClickListener {
            if (userManager.onUserLogout()) {
                startActivityAfterFinishThis(OnBoardingActivity::class.java)
            }
        }
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}