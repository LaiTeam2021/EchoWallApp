package com.laiteam.echowall.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.user.UserManager

abstract class DaggerBaseActivity<VM : ViewBinding> : BaseActivity<VM>() {
    lateinit var activityComponent: ActivityComponent
    lateinit var userManager: UserManager
    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = app.appComponent.activityComponent().create()
        userManager = app.appComponent.userManager()
        setupActivityScopeInject(activityComponent)
        super.onCreate(savedInstanceState)
    }

    protected open fun setupActivityScopeInject(activityComponent: ActivityComponent){}
}