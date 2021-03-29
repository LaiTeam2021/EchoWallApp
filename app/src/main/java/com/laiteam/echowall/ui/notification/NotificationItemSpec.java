package com.laiteam.echowall.ui.notification;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;
import com.laiteam.echowall.R;
import com.laiteam.echowall.component.Dot;
import com.laiteam.echowall.component.ProfilePhoto;

@LayoutSpec
public class NotificationItemSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop Boolean isRead) {
        return Column.create(c)
                .paddingDip(YogaEdge.VERTICAL, 4)
                .child(Card.create(c).content(getInnerComponent(c, isRead)).cornerRadiusDip(4).shadowBottomOverrideDip(3))
                .build();
    }

    private static Component getInnerComponent(ComponentContext c, Boolean isRead) {
        return Row.create(c)
                .child(isRead ? null : Dot.create(c)
                        .color(Color.parseColor("#F5B844"))
                        .dotSize(8)
                        .paddingDip(YogaEdge.TOP,20))
                .child(ProfilePhoto.create(c)
                        .imageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsb1qQK_OC0hbq954zl-ulzsnqY4H8rxlzyQ&usqp=CAU")
                        .wDip(45).hDip(45)
                        .failureResRes(R.drawable.shape_profile_photo))
                .child(Column.create(c)
                        .paddingDip(YogaEdge.VERTICAL, 12)
                        .paddingDip(YogaEdge.LEFT, 8)
                        .backgroundColor(Color.WHITE)
                        .child(Row.create(c)
                                .child(Text.create(c).textSizeSp(16).text("Jane Doe ").textColorRes(R.color.primary_yellow))
                                .child(Text.create(c).textSizeSp(16).text("commented on your post").textColor(Color.BLACK)).build())
                        .child(Text.create(c).textSizeSp(12).text("22:10 02/28/2021").textColor(Color.GRAY))
                        .build())
                .build();

    }
}
