package com.laiteam.echowall.base.recycler

import com.facebook.litho.Component
import com.facebook.litho.ComponentContext

abstract class ComponentRenderInfo<Data>(val data: Data) {

    abstract fun createComponent(c : ComponentContext) : Component


}