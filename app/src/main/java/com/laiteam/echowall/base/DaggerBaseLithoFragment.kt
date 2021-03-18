package com.laiteam.echowall.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.laiteam.echowall.databinding.FragmentBaseLithoBinding

abstract class DaggerBaseLithoFragment<T> :
    DaggerBaseFragment<FragmentBaseLithoBinding>() {
    protected val c: ComponentContext by lazy {
        ComponentContext(context)
    }

    override fun createFragmentViewBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ): FragmentBaseLithoBinding {
        return FragmentBaseLithoBinding.inflate(
                inflater,
                container,
                false
        )
    }

    fun setComponentAsync(component: Component) {
        binding.lithoView.setComponentAsync(component)
    }

    override fun onDestroyView() {
        binding.lithoView.release()
        super.onDestroyView()
    }
}