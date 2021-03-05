package com.laiteam.echowall.ui.me

import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.base.DaggerBaseUserLithoFragment
import com.laiteam.echowall.di.user.UserActivityComponent

class MeFragment : DaggerBaseUserLithoFragment() {
    override fun setupInjection(userActivityComponent: UserActivityComponent) {

    }

    override fun initData() {
        val environment = MeEnvironment(NavHostFragment.findNavController(this), userManager)
        setComponentAsync(MeActivityComponent.create<MeEnvironment>(c).environment(environment).build())
    }
}