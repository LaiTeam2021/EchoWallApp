package com.laiteam.echowall.base

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.App
import com.laiteam.echowall.di.user.UserActivityComponent
import com.laiteam.echowall.user.UserManager

abstract class DaggerBaseUserFragment<VM : ViewBinding> : BaseFragment<VM>() {

    lateinit var userManager: UserManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userManager = (context.applicationContext
                as App).appComponent.userManager()
        setupInjection((context as DaggerBaseUserActivity<*>).userActivityComponent)
    }

    protected open fun setupInjection(userActivityComponent: UserActivityComponent) {}
}