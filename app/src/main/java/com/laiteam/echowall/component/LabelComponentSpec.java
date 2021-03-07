package com.laiteam.echowall.component;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;

import static android.graphics.Typeface.BOLD;

/**
 * Rebuild the project to generate component boilerplate
 */
@LayoutSpec
class LabelComponentSpec{

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop String label) {

        return Column.create(c)
                .paddingDip(YogaEdge.HORIZONTAL, 8f)
                .paddingDip(YogaEdge.VERTICAL, 4f)
                .child(getTextComponent(c, label))
                .build();
    }

    static Component getTextComponent(ComponentContext c, CharSequence text) {
        return Text.create(c)
                .textColorRes(R.color.primary_text_color)
                .textSizeSp(16f)
                .text(text)
                .textStyle(BOLD).build();
    }
}