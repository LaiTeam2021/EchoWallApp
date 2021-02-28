package com.laiteam.echowall.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.laiteam.echowall.base.DaggerBaseUserFragment
import com.laiteam.echowall.databinding.FragmentFeedBinding
import com.laiteam.echowall.di.user.UserActivityComponent
import javax.inject.Inject

class FeedFragment : DaggerBaseUserFragment<FragmentFeedBinding>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: FeedViewModel by viewModels {
        viewModelFactory
    }


    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
       return FragmentFeedBinding.inflate(layoutInflater, container, false)
    }

    override fun setupInjection(userActivityComponent: UserActivityComponent) {
            userActivityComponent.inject(this)
    }

    override fun initViews() {
        // TODO("Not yet implemented")
    }

    override fun initData() {
       // TODO("Not yet implemented")
    }
}