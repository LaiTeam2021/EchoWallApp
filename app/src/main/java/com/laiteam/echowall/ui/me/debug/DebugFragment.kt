package com.laiteam.echowall.ui.me.debug

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.laiteam.echowall.base.DaggerBaseUserLithoFragment
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.network.response.Status
import javax.inject.Inject

class DebugFragment : DaggerBaseUserLithoFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: DebugViewModel by viewModels {
        viewModelFactory
    }

    override fun setupInjection(userActivityComponent: UserActivityComponent) {
        userActivityComponent.inject(this)
    }


    override fun initData() {
        viewModel.serverInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS -> it.data?.let { data ->
                    setComponentAsync(DebugFragmentComponent.create(c).severInfo(data).build())
                }
                Status.ERROR -> Toast.makeText(context, it.message!!, Toast.LENGTH_SHORT).show()
                else -> {
                }
            }
        }
    }
}