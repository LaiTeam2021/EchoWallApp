package com.laiteam.echowall.ui.notification;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;

@LayoutSpec
public class NotificationItemSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c) {
        return Column.create(c)
                .paddingDip(YogaEdge.VERTICAL, 4)
                .child(Card.create(c)
                        .content(getInnerComponent(c)).cornerRadiusDip(4).shadowBottomOverrideDip(3)).build();
    }

    private static Component getInnerComponent(ComponentContext c) {
        return Column.create(c)
                .paddingDip(YogaEdge.ALL, 16)
                .backgroundColor(Color.WHITE)
                .child(
                        Row.create(c).child(
                                Text.create(c).textSizeSp(16).text("Jane Doe ").textColorRes(R.color.primary_yellow)
                        ).child(Text.create(c).textSizeSp(16).text("commented on your post").textColor(Color.BLACK))
                                .build()
                )
                .child(Text.create(c).textSizeSp(12).text("22:10 02/28/2021").textColor(Color.GRAY)).build();
    }
}
