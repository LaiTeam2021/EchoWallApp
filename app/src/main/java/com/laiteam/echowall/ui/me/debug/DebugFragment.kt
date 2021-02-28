package com.laiteam.echowall.ui.me.debug

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.facebook.litho.widget.RecyclerBinder
import com.laiteam.echowall.base.DaggerBaseUserLithoFragment
import com.laiteam.echowall.base.recycler.ComponentPopulator
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.network.model.SeverInfo
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
                Status.SUCCESS -> addContent(recyclerBinder, it.data!!)
                else -> {
                }
            }
        }
    }

    private fun addContent(recyclerBinder: RecyclerBinder, severInfo: SeverInfo) {
        ComponentPopulator(recyclerBinder, c).addRow(
            LabelRowRenderInfo("name: " + severInfo.name)
        ).addRow(
            LabelRowRenderInfo("environment: " + severInfo.environment)
        ).addRow(
            LabelRowRenderInfo("version: " + severInfo.version)
        )
    }
}