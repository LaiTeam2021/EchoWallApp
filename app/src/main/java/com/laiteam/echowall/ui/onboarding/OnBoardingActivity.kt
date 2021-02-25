package com.laiteam.echowall.ui.onboarding

import android.widget.Toast
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseActivity
import com.laiteam.echowall.databinding.ActivityOnBoardingBinding
import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.ui.MainActivity

class OnBoardingActivity : DaggerBaseActivity<ActivityOnBoardingBinding>() {

    override fun setupActivityScopeInject(activityComponent: ActivityComponent) {
    }

    override fun initViews() {
        super.initViews()
        if (userManager.shouldAutoLogin()) {
            startActivityAfterFinishThis(MainActivity::class.java)
        }
        binding.submit.setOnClickListener {
            val userName = binding.userName.text.toString()
            if (userName.isBlank()) {
                Toast.makeText(
                    this@OnBoardingActivity,
                    getString(R.string.error_user_name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                userManager.onUserLogin(userName)
                startActivityAfterFinishThis(MainActivity::class.java)
            }
        }
    }


    override fun createViewBinding(): ActivityOnBoardingBinding {
        return ActivityOnBoardingBinding.inflate(layoutInflater)
    }
}