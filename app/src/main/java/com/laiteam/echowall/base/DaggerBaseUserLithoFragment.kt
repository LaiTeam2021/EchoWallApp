package com.laiteam.echowall.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.OrientationHelper
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.widget.LinearLayoutInfo
import com.facebook.litho.widget.Recycler
import com.facebook.litho.widget.RecyclerBinder
import com.laiteam.echowall.databinding.FragmentBaseLithoBinding

abstract class DaggerBaseUserLithoFragment :
    DaggerBaseUserFragment<FragmentBaseLithoBinding>() {
    protected val c: ComponentContext by lazy {
        ComponentContext(context)
    }
    protected var _recyclerBinder: RecyclerBinder? = null

    override fun initViews() {
        _recyclerBinder = RecyclerBinder.Builder()
            .layoutInfo(LinearLayoutInfo(context, OrientationHelper.VERTICAL, false))
            .build(c)
        val component = Recycler.create(c).binder(recyclerBinder).build()
        setComponentAsync(component)
    }

    protected val recyclerBinder get() = (_recyclerBinder!!)

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
        _recyclerBinder = null
        super.onDestroyView()
    }
}