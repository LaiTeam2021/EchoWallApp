package com.laiteam.echowall.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentMainBinding
import com.laiteam.echowall.di.fragment.FragmentComponent

class MainFragment : DaggerBaseFragment<FragmentMainBinding>() {

    override fun initData() {
        binding.mainViewpager.adapter = MainViewPagerAdapter(childFragmentManager)

        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel
                .toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED, resources.getDimension(R.dimen.radius_8dp))
                .setTopRightCorner(CornerFamily.ROUNDED, resources.getDimension(R.dimen.radius_8dp))
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

    override fun createFragmentViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding? {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    open override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }
}