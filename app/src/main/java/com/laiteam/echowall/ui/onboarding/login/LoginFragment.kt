package com.laiteam.echowall.ui.onboarding.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.laiteam.echowall.R
import com.laiteam.echowall.base.DaggerBaseFragment
import com.laiteam.echowall.databinding.FragmentLoginBinding
import com.laiteam.echowall.ui.main.MainActivity

class LoginFragment : DaggerBaseFragment<FragmentLoginBinding>() {

    override fun initViews() {
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
        binding.register.setOnClickListener { _view ->
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