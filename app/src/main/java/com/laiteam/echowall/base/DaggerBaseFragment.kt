package com.laiteam.echowall.base

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.App
import com.laiteam.echowall.di.user.ActivityComponent
import com.laiteam.echowall.user.UserManager

abstract class DaggerBaseFragment<VM : ViewBinding> : BaseFragment<VM>() {

    lateinit var userManager: UserManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupActivityScopeInject((context as DaggerBaseActivity<*>).activityComponent)
        userManager = (context.application
            as App).appComponent.userManager()
    }

    protected open fun setupActivityScopeInject(activityComponent: ActivityComponent){}
}