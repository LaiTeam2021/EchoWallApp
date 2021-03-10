package com.laiteam.echowall.ui.onboarding.login

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.laiteam.echowall.R
import com.laiteam.echowall.base.BaseFragment
import com.laiteam.echowall.databinding.FragmentLoginBinding
import com.laiteam.echowall.ui.main.MainActivity
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the registrationComponent from the Activity and injects this Fragment
        (activity as OnBoardingActivity).onBoardingComponent.inject(this)
    }

    override fun initData() {
        if (userManager.shouldAutoLogin()) {
            startActivityAfterFinishThis(MainActivity::class.java)
        }
        binding.submit.setOnClickListener {
            val userName = binding.userName.text.toString()
            if (userName.isBlank()) {
                Toast.makeText(
                    context,
                    getString(R.string.error_user_name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                userManager.onUserLogin(userName)
                startActivityAfterFinishThis(MainActivity::class.java)
            }
        }
        binding.register.setOnClickListener { _ ->
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    override fun createFragmentViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding? {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }
}