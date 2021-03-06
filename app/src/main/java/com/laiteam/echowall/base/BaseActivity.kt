package com.laiteam.echowall.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.App
import com.laiteam.echowall.user.UserManager

abstract class BaseActivity<VM : ViewBinding?> : AppCompatActivity() {
   protected lateinit var userManager: UserManager
    private var _binding: VM? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userManager = app.appComponent.userManager()
        _binding = createViewBinding()
        setContentView(_binding!!.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
        initData()
    }

    protected open fun initViews() {}

    protected open fun initData() {}

    fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    fun startActivityAfterFinishThis(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected abstract fun createViewBinding(): VM?
    protected val app: App
        get() = application as App

    protected val binding get() = (_binding!! as VM)
}