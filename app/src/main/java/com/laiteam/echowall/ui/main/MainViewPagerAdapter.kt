package com.laiteam.echowall.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.laiteam.echowall.ui.feed.FeedFragment

class MainViewPagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {


    override fun getItemCount() = 4;

    override fun createFragment(position: Int): Fragment {
        return FeedFragment()
    }
}