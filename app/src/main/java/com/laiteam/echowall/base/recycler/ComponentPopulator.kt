package com.laiteam.echowall.base.recycler

import com.facebook.litho.ComponentContext
import com.facebook.litho.widget.RecyclerBinder
import java.util.concurrent.locks.ReentrantLock

class ComponentPopulator(
    private val recyclerBinder: RecyclerBinder,
    private val c: ComponentContext
) {
    private val componentRenderInfos = ArrayList<ComponentRenderInfo<*>>()
    private val lock = ReentrantLock()

    fun addRow(
        componentRenderInfo: ComponentRenderInfo<*>
    ): ComponentPopulator {
        try {
            lock.lock()
            componentRenderInfos.add(componentRenderInfo)
        } finally {
            lock.unlock()
        }
        recyclerBinder.appendItem(componentRenderInfo.createComponent(c))
        return this
    }

    fun removeRow(index: Int): ComponentPopulator {
        try {
            if (index < 0 || index >= componentRenderInfos.size) {
                return this
            }
            lock.lock()
            componentRenderInfos.removeAt(index)
        } finally {
            lock.unlock()
        }
        recyclerBinder.removeItemAt(index)
        return this
    }

    fun removeRow(ComponentRenderInfo: ComponentRenderInfo<*>): ComponentPopulator {
        var index: Int
        try {
            lock.lock()
            index = componentRenderInfos.indexOf(ComponentRenderInfo)
            if (index == -1) {
                return this;
            }
            componentRenderInfos.removeAt(index)
        } finally {
            lock.unlock()
        }

        recyclerBinder.removeItemAt(index)
        return this
    }

    fun updateRow(ComponentRenderInfo: ComponentRenderInfo<*>): ComponentPopulator {
        val index = componentRenderInfos.indexOf(ComponentRenderInfo)
        if (index != -1) {
            recyclerBinder.updateItemAt(index, ComponentRenderInfo.createComponent(c))
        }
        return this
    }
}