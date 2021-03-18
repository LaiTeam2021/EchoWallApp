package com.laiteam.echowall.base

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.di.fragment.FragmentComponent
import com.laiteam.echowall.di.fragment.FragmentModule

abstract class DaggerBaseFragment<VM : ViewBinding> : BaseFragment<VM>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupInjection(
            (context as DaggerBaseActivity<*>).activityComponent.fragmentComponent().create(FragmentModule(this))
        )
    }

    protected open fun setupInjection(fragmentComponent: FragmentComponent) {}
}