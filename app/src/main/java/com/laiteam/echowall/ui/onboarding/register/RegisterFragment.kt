package com.laiteam.echowall.ui.onboarding.register

import android.view.LayoutInflater
import android.view.ViewGroup
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentLoginBinding
import com.laiteam.echowall.databinding.FragmentRegisterBinding
import com.laiteam.echowall.di.activity.ActivityComponent

class RegisterFragment : DaggerBaseFragment<FragmentRegisterBinding>() {


    override fun initViews() {
    }

    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding? {
        return FragmentRegisterBinding.inflate(inflater, container, false);
    }
}