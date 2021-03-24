package com.laiteam.echowall.ui.me;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.laiteam.echowall.BuildConfig;
import com.laiteam.echowall.R;
import com.laiteam.echowall.base.DaggerBaseActivity;
import com.laiteam.echowall.base.environment.HasNavigator;
import com.laiteam.echowall.base.environment.HasUserManager;
import com.laiteam.echowall.component.LabelComponent;
import com.laiteam.echowall.ui.main.MainFragment;
import com.laiteam.echowall.ui.main.MainFragmentDirections;
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity;
import com.laiteam.echowall.util.ContextWrapperUtils;

/**
 * This is a java class
 */
@LayoutSpec
class MeFragmentRootComponentSpec<E extends HasNavigator & HasUserManager> {

    @OnCreateLayout
    static <E extends HasNavigator, HasUserManage> Component onCreateLayout(ComponentContext c, @Prop E environment) {
        return Column.create(c)
                .child(BuildConfig.DEBUG ? LabelComponent.create(c)
                        .label(c.getString(R.string.debug)).clickHandler(MeFragmentRootComponent.onClickDebug(c)) : null)
                .child(LabelComponent.create(c)
                        .label(c.getString(R.string.logout)).clickHandler(MeFragmentRootComponent.onClickLogout(c)))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static <E extends HasNavigator & HasUserManager> void onClickDebug(
            ComponentContext c,
            @Prop E environment) {
        environment.getNavigator().navigateFrom(MainFragmentDirections.Companion.actionMainFragmentToDebugFragment(), MainFragment.class);
    }

    @OnEvent(ClickEvent.class)
    static <E extends HasNavigator & HasUserManager> void onClickLogout(
            ComponentContext c,
            @Prop E environment) {
        if (environment.getUserManager().onUserLogout()) {
            DaggerBaseActivity<?> activity = ContextWrapperUtils.Companion.findContextOfType(c.getAndroidContext(), DaggerBaseActivity.class);
            if (activity != null && !activity.isFinishing()) {
                activity.startActivityAfterFinishThis(OnBoardingActivity.class);
            }
        }
    }
}