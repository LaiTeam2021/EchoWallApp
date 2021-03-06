package com.laiteam.echowall.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FeedPagerAdapter(private val topics: List<String>, fm: FragmentManager) : FragmentStatePagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount(): Int {
        return topics.size
    }

    override fun getItem(position: Int): Fragment {
        return TabFragment.newInstance(topics[position])
    }

    override fun getPageTitle(position: Int) = topics[position]
}