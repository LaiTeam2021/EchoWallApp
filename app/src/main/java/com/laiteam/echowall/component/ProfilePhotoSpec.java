package com.laiteam.echowall.component;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;


@LayoutSpec
public class ProfilePhotoSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop String imageUrl,
                                    @Prop int w, @Prop int h, @Prop int failureRes) {

        return FrescoImage.create(c)
                .controller(getImageComponent(imageUrl))
                .failureImageRes(failureRes)
                .widthDip(w).heightDip(h)
                .build();
    }

    static DraweeController getImageComponent(String imageUrl) {

        return Fresco.newDraweeControllerBuilder()
                     .setUri(imageUrl)
                     .build();
    }
}
