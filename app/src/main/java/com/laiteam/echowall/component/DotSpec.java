package com.laiteam.echowall.component;

import android.widget.ImageView;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.laiteam.echowall.R;


@LayoutSpec
public class DotSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop int color, @Prop int dotSize) {
        return Column.create(c)
                .child(getComponent(c, color, dotSize))
                .build();
    }

    static Component getComponent(ComponentContext c, int color, int dotSize) {
        return Image.create(c)
                .drawableRes(R.drawable.shape_dot)
                .widthDip(dotSize).heightDip(dotSize)
                .backgroundColor(color)
                .scaleType(ImageView.ScaleType.CENTER_CROP)
                .build();
    }
}
