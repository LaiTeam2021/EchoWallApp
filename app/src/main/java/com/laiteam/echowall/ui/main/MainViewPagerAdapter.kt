package com.laiteam.echowall.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.R

class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            1 -> NavHostFragment.create(R.navigation.feed_nav_graph)
            2 -> NavHostFragment.create(R.navigation.notification_nav_graph)
            3 -> NavHostFragment.create(R.navigation.me_nav_graph)
            else ->
                NavHostFragment.create(R.navigation.feed_nav_graph)
        }
    }
}