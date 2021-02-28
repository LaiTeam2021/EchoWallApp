package com.laiteam.echowall.ui.me;

import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;
import com.laiteam.echowall.base.environment.Environment;
import com.laiteam.echowall.base.environment.EnvironmentImp;

import static android.graphics.Typeface.BOLD;

/**
 * Rebuild the project to generate component boilerplate
 */
@LayoutSpec
class LabelComponentSpec<E extends Environment> {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop String label) {

        return Column.create(c)
                .paddingDip(YogaEdge.HORIZONTAL, 8f)
                .paddingDip(YogaEdge.VERTICAL, 4f)
                .child(getTextComponent(c, label))
                .clickHandler(LabelComponent.onClickEvent(c))
                .build();
    }

    static Component getTextComponent(ComponentContext c, CharSequence text) {
        return Text.create(c)
                .textColorRes(R.color.black)
                .textSizeSp(16f)
                .text(text)
                .textStyle(BOLD).build();
    }

    @OnEvent(ClickEvent.class)
    static <E extends Environment> void onClickEvent(ComponentContext c, @Prop(optional = true) E environment, @FromEvent View view) {
        if (environment != null) {
            environment.navigate(MeFragmentDirections.Companion.actionMeFragmentToDebugFragment());
        }
    }
}