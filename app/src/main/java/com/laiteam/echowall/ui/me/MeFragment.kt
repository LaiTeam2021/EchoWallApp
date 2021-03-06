package com.laiteam.echowall.ui.me

import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.base.DaggerBaseLithoFragment

class MeFragment : DaggerBaseLithoFragment() {

    override fun initData() {
        val environment = MeEnvironment(NavHostFragment.findNavController(this), userManager)
        setComponentAsync(MeFragmentRootComponent.create<MeEnvironment>(c).environment(environment).build())
    }
}