package com.laiteam.echowall.ui.notification

import com.facebook.litho.widget.Text
import com.laiteam.echowall.base.DaggerBaseLithoFragment

class NotificationFragment : DaggerBaseLithoFragment() {

    override fun initData() {
        setComponentAsync(Text.create(c).text("Notification").build())
    }
}