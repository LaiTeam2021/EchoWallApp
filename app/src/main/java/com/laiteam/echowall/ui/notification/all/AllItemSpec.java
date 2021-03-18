package com.laiteam.echowall.ui.notification.all;

import android.graphics.Color;

import com.facebook.litho.Border;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;
import com.laiteam.echowall.component.LabelComponent;

@LayoutSpec
public class AllItemSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c) {
        return Column.create(c)
                .paddingDip(YogaEdge.ALL, 16)
                .backgroundColor(Color.WHITE)
                .child(
                        Row.create(c).child(
                            Text.create(c).textSizeSp(16).text("Jane Doe ").textColorRes(R.color.yellow)
                        ).child(Text.create(c).textSizeSp(16).text("commented on your post").textColor(Color.BLACK))
                        .build()
                )
                .child(Text.create(c).textSizeSp(12).text("22:10 02/28/2021").textColor(Color.GRAY))
                .border(Border.create(c)
                        .widthDip(YogaEdge.ALL, 1)
                        .color(YogaEdge.ALL, Color.GRAY)
                        .radiusDip(4f)
                        .build())
                .build();
    }
}
