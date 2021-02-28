package com.laiteam.echowall.ui.me

import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.BuildConfig
import com.laiteam.echowall.base.DaggerBaseUserLithoFragment
import com.laiteam.echowall.base.environment.EnvironmentImp
import com.laiteam.echowall.base.recycler.ComponentPopulator
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.ui.me.debug.LabelRowRenderInfo

class MeFragment: DaggerBaseUserLithoFragment() {
    override fun setupInjection(userActivityComponent: UserActivityComponent) {

    }

    override fun initData() {
        val environment = EnvironmentImp(NavHostFragment.findNavController(this))
        if (BuildConfig.DEBUG) {
            ComponentPopulator(recyclerBinder, c).addRow(
                LabelRowRenderInfo("Debug Setting", environment))
        }

    }
}