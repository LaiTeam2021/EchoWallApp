package com.laiteam.echowall.component;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.laiteam.echowall.R;

@LayoutSpec
public class ProfilePhotoSpec {
    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop String imageUrl) {

        return FrescoImage.create(c)
                .controller(getImageComponent(imageUrl))
                .failureImageRes(R.drawable.shape_profile_photo)
                .widthDip(45).heightDip(45)
                .build();
    }

    static DraweeController getImageComponent(String imageUrl) {

        return Fresco.newDraweeControllerBuilder()
                     .setUri(imageUrl)
                     .build();
    }
}
