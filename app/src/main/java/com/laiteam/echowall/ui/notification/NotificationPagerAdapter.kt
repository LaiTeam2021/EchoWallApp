package com.laiteam.echowall.ui.notification

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class NotificationPagerAdapter(private val all_unread: List<String>, fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount(): Int {
        return all_unread.size
    }

    override fun getItem(position: Int): Fragment {
        return NotificationTabFragment.newInstance(all_unread[position])
    }

    override fun getPageTitle(position: Int) = all_unread[position]
}