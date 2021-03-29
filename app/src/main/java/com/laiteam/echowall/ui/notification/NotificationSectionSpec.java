package com.laiteam.echowall.ui.notification;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.laiteam.echowall.ui.notification.NotificationItem;

@GroupSectionSpec
public class NotificationSectionSpec {
    @OnCreateChildren
    static Children onCreateChildren(final SectionContext context, @Prop int size, @Prop Boolean isRead) {
        Children.Builder builder = Children.create();
        for (int i = 0; i < size; i++) {
            builder.child(
                    SingleComponentSection.create(context)
                            .key(String.valueOf(i))
                            .component(NotificationItem.create(context)
                                    .isRead(isRead)
                                    .build()
                            )
            );
        }
        return builder.build();
    }
}
