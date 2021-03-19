package com.laiteam.echowall.ui.onboarding.login

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.laiteam.echowall.R
import com.laiteam.echowall.base.BaseFragment
import com.laiteam.echowall.databinding.FragmentLoginBinding
import com.laiteam.echowall.network.response.Status
import com.laiteam.echowall.ui.main.MainActivity
import com.laiteam.echowall.ui.onboarding.OnBoardingActivity
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the registrationComponent from the Activity and injects this Fragment
        (activity as OnBoardingActivity).onBoardingComponent.inject(this)
    }

    override fun initData() {
        // check auto login
        if (userManager.shouldAutoLogin()) {
            startActivityAfterFinishThis(MainActivity::class.java)
            return
        }
        // login
        binding.loginButton.setOnClickListener {
            val userEmail = binding.loginEmailAddress.text.toString()
            val userPassword = binding.loginPassword.text.toString()
            viewModel.setLogin(userEmail, userPassword)
        }
        // show password
        binding.loginShowPassword.setOnClickListener {
            viewModel.togglePasswordVisible();
        }

        viewModel.passwordVisible.observe(this) { isVisible ->
            binding.loginPassword.transformationMethod = if (isVisible) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
            binding.loginShowPassword.setImageResource(if (isVisible) R.drawable.ic_baseline_remove_red_eye_24 else R.drawable.ic_outline_remove_red_eye_24)
        }
        // sign up
        binding.register.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
        // as below are temp function
        viewModel.loginInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS -> it.data?.let { data ->
                    Toast.makeText(context, "Welcome!", Toast.LENGTH_SHORT).show()
                    // still need to update userManager
                    userManager.onUserLogin(data)
                    startActivityAfterFinishThis(MainActivity::class.java)
                }
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                else -> {

                }
            }
        }
    }

    override fun createFragmentViewBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ): FragmentLoginBinding? {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

}



