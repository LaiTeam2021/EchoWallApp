package com.laiteam.echowall.ui.me

import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.di.fragment.FragmentComponent
import javax.inject.Inject

<<<<<<< HEAD
class MeFragment : DaggerBaseLithoFragment() {
    @Inject
    lateinit var navigator: Navigator
=======
class MeFragment : DaggerBaseLithoFragment<Any?>() {
>>>>>>> combine 4 commits into 1

    override fun initData() {
        val environment = MeEnvironment(navigator, userManager)
        setComponentAsync(MeFragmentRootComponent.create<MeEnvironment>(c).environment(environment).build())
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }
}