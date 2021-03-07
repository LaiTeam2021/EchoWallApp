package com.laiteam.echowall.ui.me.debug

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.di.fragment.FragmentComponent
import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.network.response.Status
import javax.inject.Inject

class DebugFragment : DaggerBaseLithoFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: DebugViewModel by viewModels {
        viewModelFactory
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }


    override fun initData() {
        viewModel.serverInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS -> it.data?.let { data ->
                    setComponentAsync(DebugFragmentRootComponent.create(c).severInfo(data).build())
                }
                Status.ERROR -> Toast.makeText(context, it.message!!, Toast.LENGTH_SHORT).show()
                else -> {
                }
            }
        }
    }
}