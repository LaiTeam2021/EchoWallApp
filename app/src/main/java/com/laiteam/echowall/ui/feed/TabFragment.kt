package com.laiteam.echowall.ui.feed

import androidx.core.os.bundleOf
import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.component.LabelComponent

class TabFragment : DaggerBaseLithoFragment() {
    companion object {
        private const val MY_TAB_NAME = "tab_name"

        fun newInstance(tabName: String) = TabFragment().apply {
            arguments = bundleOf(
                MY_TAB_NAME to tabName,
            )
        }
    }

    override fun initData() {
        arguments?.getString(MY_TAB_NAME)?.let {tabName ->
            setComponentAsync(LabelComponent.create(c).label(tabName).build())
        }

    }
}