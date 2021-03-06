package com.laiteam.echowall.ui.main

import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.shape.CornerFamily.ROUNDED
import com.google.android.material.shape.MaterialShapeDrawable
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseActivity
import com.laiteam.echowall.databinding.ActivityMainBinding
import com.laiteam.echowall.di.user.ActivityComponent


class MainActivity : DaggerBaseActivity<ActivityMainBinding>() {

    override fun initViews() {
        binding.mainViewpager.adapter = MainViewPagerAdapter(supportFragmentManager)

        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel
                .toBuilder()
                .setTopLeftCorner(ROUNDED, resources.getDimension(R.dimen.radius_8dp))
                .setTopRightCorner(ROUNDED, resources.getDimension(R.dimen.radius_8dp))
                .build()
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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

    override fun setupInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}