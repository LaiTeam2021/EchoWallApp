package com.laiteam.echowall.ui.notification

import androidx.core.os.bundleOf
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.laiteam.echowall.base.DaggerBaseLithoFragment

import com.laiteam.echowall.ui.notification.NotificationSection


class NotificationTabFragment : DaggerBaseLithoFragment(){
    companion object {
        private const val MY_TAB_NAME = "tab_name"

        fun newInstance(tabName: String) = NotificationTabFragment().apply {
            arguments = bundleOf(
                MY_TAB_NAME to tabName,
            )
        }
    }

    override fun initData() {
        arguments?.getString(MY_TAB_NAME)?.let { tabName ->
            setComponentAsync(RecyclerCollectionComponent.create(c).disablePTR(true)
                            .section(NotificationSection.create(SectionContext(c))
                                    .size(arguments?.getString(MY_TAB_NAME)!!.length)
                                    .isRead(false)
                                    .build())
                            .build())

        }
    }
}