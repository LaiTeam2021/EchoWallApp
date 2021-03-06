package com.laiteam.echowall.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentFeedBinding
import com.laiteam.echowall.di.fragment.FragmentComponent

class FeedFragment : DaggerBaseFragment<FragmentFeedBinding>() {

    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
        return FragmentFeedBinding.inflate(layoutInflater, container, false)
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun initData() {
        binding.tabLayout.setupWithViewPager(binding.pager)
        binding.pager.adapter = FeedPagerAdapter(listOf("求职", "灌水", "移民"), getParentFragmentManager())
    }
}