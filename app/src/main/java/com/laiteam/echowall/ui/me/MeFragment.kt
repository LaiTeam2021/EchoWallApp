package com.laiteam.echowall.ui.me

import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.di.fragment.FragmentComponent
import javax.inject.Inject

class MeFragment : DaggerBaseLithoFragment() {
    @Inject
    lateinit var navigator: Navigator

    override fun initData() {
        val environment = MeEnvironment(navigator, userManager)
        setComponentAsync(MeFragmentRootComponent.create<MeEnvironment>(c).environment(environment).build())
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }
}