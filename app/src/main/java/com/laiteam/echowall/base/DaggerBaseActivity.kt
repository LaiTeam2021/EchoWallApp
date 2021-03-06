package com.laiteam.echowall.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.di.user.ActivityComponent

abstract class DaggerBaseActivity<VM : ViewBinding> : BaseActivity<VM>() {

    lateinit var activityComponent: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = userManager.userComponent!!.activityComponent().create()
        setupInjection(activityComponent)
    }

    protected open fun setupInjection(activityComponent: ActivityComponent) {}
}