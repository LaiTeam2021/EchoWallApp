package com.laiteam.echowall.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.user.UserManager

abstract class DaggerBaseUserActivity<VM : ViewBinding> : BaseActivity<VM>() {
    lateinit var userActivityComponent: UserActivityComponent
    lateinit var userManager: UserManager
    lateinit var userComponent: UserComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        userManager = app.appComponent.userManager()
        userComponent = userManager.userComponent!!
        userActivityComponent = userComponent.userActivityComponent().create()
        setupInjection(userActivityComponent)
        super.onCreate(savedInstanceState)
    }

    protected open fun setupInjection(userActivityComponent: UserActivityComponent){}
}