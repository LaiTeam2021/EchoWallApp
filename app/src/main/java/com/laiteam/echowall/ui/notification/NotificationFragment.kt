package com.laiteam.echowall.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentNotificationBinding
import com.laiteam.echowall.di.fragment.FragmentComponent

class NotificationFragment : DaggerBaseFragment<FragmentNotificationBinding>() {

    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(layoutInflater, container, false)
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun initData() {
        binding.tabLayout.setupWithViewPager(binding.pager)
        binding.pager.adapter = NotificationPagerAdapter(listOf("All", "Unread"), getParentFragmentManager())
    }
}