package com.laiteam.echowall.ui.notification.all;

import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.SingleComponentSection;

@GroupSectionSpec
public class AllSectionSpec {
    @OnCreateChildren
    static Children onCreateChildren(final SectionContext context, @Prop int size) {
        Children.Builder builder = Children.create();
        for (int i = 0; i < size; i++) {
            builder.child(
                    SingleComponentSection.create(context)
                            .key(String.valueOf(i))
                            .component(AllItem.create(context)
                                    .build()
                            )
            );
        }
        return builder.build();
    }
}
