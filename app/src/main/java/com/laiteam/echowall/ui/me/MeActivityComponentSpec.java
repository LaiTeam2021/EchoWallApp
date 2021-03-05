package com.laiteam.echowall.ui.me;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.laiteam.echowall.R;
import com.laiteam.echowall.base.DaggerBaseUserActivity;
import com.laiteam.echowall.base.environment.HasNavigator;
import com.laiteam.echowall.base.environment.HasUserManager;
import com.laiteam.echowall.component.LabelComponent;
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity;
import com.laiteam.echowall.util.ContextWrapperUtils;

/** This is a java class */
@LayoutSpec
class MeActivityComponentSpec<E extends HasNavigator & HasUserManager> {

    @OnCreateLayout
    static <E extends HasNavigator, HasUserManage> Component onCreateLayout(ComponentContext c, @Prop E environment) {
        return Column.create(c)
                .child(LabelComponent.create(c)
                        .label(c.getString(R.string.debug)).clickHandler(MeActivityComponent.onClickDebug(c)))
                .child(LabelComponent.create(c)
                        .label(c.getString(R.string.logout)).clickHandler(MeActivityComponent.onClickLogout(c)))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static <E extends HasNavigator & HasUserManager> void onClickDebug(
            ComponentContext c,
            @Prop E environment) {
        environment.getNavigator().navigate(MeFragmentDirections.Companion.actionMeFragmentToDebugFragment());
    }

    @OnEvent(ClickEvent.class)
    static <E extends HasNavigator & HasUserManager> void onClickLogout(
            ComponentContext c,
            @Prop E environment) {
        if (environment.getUserManager().onUserLogout()) {
            DaggerBaseUserActivity<?> activity = ContextWrapperUtils.Companion.findContextOfType(c.getAndroidContext(), DaggerBaseUserActivity.class);
            if (activity != null && !activity.isFinishing()) {
                activity.startActivityAfterFinishThis(OnBoardingActivity.class);
            }
        }
    }

}