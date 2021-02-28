package com.laiteam.echowall.ui.me.debug

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.laiteam.echowall.base.environment.Environment
import com.laiteam.echowall.base.recycler.ComponentRenderInfo
import com.laiteam.echowall.ui.me.LabelComponent

class LabelRowRenderInfo(private val label: String, private val environment: Environment? = null) :
    ComponentRenderInfo<String>(label) {
    override fun createComponent(c: ComponentContext): Component {
        return LabelComponent.create<Environment>(c).label(label).environment(environment).build()
    }
}