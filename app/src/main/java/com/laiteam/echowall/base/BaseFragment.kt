package com.laiteam.echowall.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : ViewBinding?> : Fragment() {
    private var _binding: VM? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = createFragmentViewBinding(inflater, container)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }

    protected abstract fun initViews()

    protected abstract fun initData()

    protected abstract fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VM?

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected val binding get() = (_binding!! as VM)
}