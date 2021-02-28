package com.laiteam.echowall.ui.main

import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseUserActivity
import com.laiteam.echowall.databinding.ActivityMainBinding
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity

class MainActivity : DaggerBaseUserActivity<ActivityMainBinding>() {

    override fun initViews() {
        binding.logout.setOnClickListener {
            if (userManager.onUserLogout()) {
                startActivityAfterFinishThis(OnBoardingActivity::class.java)
            }
        }
        binding.mainViewpager.adapter = MainViewPagerAdapter(supportFragmentManager)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
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

    override fun onBackPressed() {
        (((binding.mainViewpager.adapter as FragmentStatePagerAdapter).instantiateItem(
            binding.mainViewpager,
            binding.mainViewpager.currentItem
        )) as NavHostFragment).apply {
            if (navController.popBackStack()) {
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun initData() {
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupInjection(userActivityComponent: UserActivityComponent) {
        userActivityComponent.inject(this)
    }
}