package com.laiteam.echowall.component;

import android.graphics.Color;
import android.widget.ImageView;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Image;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;


@LayoutSpec
public class DotSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c) {

        return Column.create(c)
                .paddingDip(YogaEdge.HORIZONTAL, 8f)
                .paddingDip(YogaEdge.VERTICAL, 4f)
                .child(getComponent(c))
                .build();
    }

    static Component getComponent(ComponentContext c) {
        return Image.create(c)
                .drawableRes(R.drawable.shape_dot).foregroundColor(Color.parseColor("#F5B844"))
                .scaleType(ImageView.ScaleType.CENTER_CROP)
                .build();
    }
}
