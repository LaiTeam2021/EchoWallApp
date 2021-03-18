package com.laiteam.echowall.ui.explore

import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.component.LabelComponent
import com.laiteam.echowall.di.fragment.FragmentComponent
import javax.inject.Inject

class ExploreFragment : DaggerBaseLithoFragment() {
    @Inject
    lateinit var navigator: Navigator

    override fun initData() {
        setComponentAsync(LabelComponent.create(c)
                .label("Explore").build())
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
    }
}