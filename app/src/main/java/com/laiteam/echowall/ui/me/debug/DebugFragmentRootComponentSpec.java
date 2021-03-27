package com.laiteam.echowall.ui.me.debug;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.laiteam.echowall.component.LabelComponent;
import com.laiteam.echowall.network.response.SeverResponse;

@LayoutSpec
class DebugFragmentRootComponentSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop SeverResponse severInfo) {
        return Column.create(c)
                .child(LabelComponent.create(c)
                        .label("Environment: " + severInfo.getEnvironment()))
                .child(LabelComponent.create(c)
                        .label("Name: " + severInfo.getName()))
                .child(LabelComponent.create(c)
                        .label("Version: " + severInfo.getVersion()))
                .build();
    }
}