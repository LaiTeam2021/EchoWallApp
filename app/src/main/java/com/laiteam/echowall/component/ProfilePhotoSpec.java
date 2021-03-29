package com.laiteam.echowall.component;

import android.graphics.drawable.Drawable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;
import com.facebook.litho.fresco.FrescoImage;


@LayoutSpec
public class ProfilePhotoSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop String imageUrl,
                                    @Prop(resType = ResType.DIMEN_SIZE) int w,
                                    @Prop(resType = ResType.DIMEN_SIZE) int h,
                                    @Prop(optional = true, resType = ResType.DRAWABLE) Drawable failureRes) {

        return FrescoImage.create(c)
                .controller(getImageComponent(imageUrl)).roundingParams(RoundingParams.fromCornersRadii(w/2,w/2,w/2,w/2))
                .failureImage(failureRes)
                .widthPx(w).heightPx(h)
                .build();
    }

    static DraweeController getImageComponent(String imageUrl) {

        return Fresco.newDraweeControllerBuilder()
                     .setUri(imageUrl)
                     .build();
    }
}
