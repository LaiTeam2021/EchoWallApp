package com.laiteam.echowall.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.App

abstract class BaseActivity<VM : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createViewBinding()
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
    }

    protected open fun initViews() {}

    protected fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    protected fun startActivityAfterFinishThis(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
        finish()
    }

    protected abstract fun createViewBinding(): VM
    protected val app: App
        get() = application as App
}