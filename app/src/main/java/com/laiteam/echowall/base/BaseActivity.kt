package com.laiteam.echowall.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.laiteam.echowall.App

abstract class BaseActivity<VM : ViewBinding?> : AppCompatActivity() {

    private var _binding: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = createViewBinding()
        setContentView(_binding!!.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initViews()
    }

    protected abstract fun initViews()

    protected abstract fun initData()

    protected fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    protected fun startActivityAfterFinishThis(clazz: Class<*>) {
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