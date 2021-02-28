package com.laiteam.echowall.ui.me.debug

import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo
import com.facebook.litho.widget.Text
import com.laiteam.echowall.R

@GroupSectionSpec
object DebugRootSectionSectionSpec {

    @OnCreateChildren
    fun onCreateChildren(
        c: SectionContext,
        @Prop data: List<String>
    ): Children {
        return Children.create()
            .child(
                DataDiffSection.create<String>(c)
                    .data(data)
                    .renderEventHandler(DebugRootSectionSection.render(c))
            )
            .build()
    }

    @OnEvent(RenderEvent::class)
    fun render(
        c: SectionContext,
        @FromEvent index: Int,
        @FromEvent model: String?
    ): RenderInfo {
        return ComponentRenderInfo.create()
            .component(
                Text.create(c).text(model).textSizeSp(15f).textColorRes(R.color.black).build()
            )
            .build()
    }
}