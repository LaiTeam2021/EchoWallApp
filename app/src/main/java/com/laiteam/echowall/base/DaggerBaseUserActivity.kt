package com.laiteam.echowall.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.user.UserManager

abstract class DaggerBaseUserActivity<VM : ViewBinding> : BaseActivity<VM>() {
    protected lateinit var activityComponent: ActivityComponent
    lateinit var userManager: UserManager
    lateinit var userComponent: UserComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = app.appComponent.activityComponent().create()
        userManager = app.appComponent.userManager()
        userComponent = userManager.userComponent!!
        setupActivityScopeInject(activityComponent)
        super.onCreate(savedInstanceState)
    }

    protected open fun setupActivityScopeInject(activityComponent: ActivityComponent){}
    protected open fun setupUserScopeInject(userComponent: UserComponent){}
}