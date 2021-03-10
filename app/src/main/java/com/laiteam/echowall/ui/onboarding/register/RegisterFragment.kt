package com.laiteam.echowall.ui.onboarding.register

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentRegisterBinding
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity
import com.laiteam.echowall.ui.onboarding.login.LoginFragmentDirections

class RegisterFragment : DaggerBaseFragment<FragmentRegisterBinding>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the registrationComponent from the Activity and injects this Fragment
        (activity as OnBoardingActivity).onBoardingComponent.inject(this)
    }

    override fun initData() {
        super.initData()
//        binding.login.setOnClickListener( _view ->
//        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment()))
    }

    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding? {
        return FragmentRegisterBinding.inflate(inflater, container, false);
    }
}