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
    val userViewModel: FeedViewModel by viewModels {
        viewModelFactory
    }


    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFeedBinding {
       var temp = userViewModel
       return FragmentFeedBinding.inflate(layoutInflater, container, false)
    }

    override fun setupInjection(userActivityComponent: UserActivityComponent) {
            userActivityComponent.inject(this)
    }
}