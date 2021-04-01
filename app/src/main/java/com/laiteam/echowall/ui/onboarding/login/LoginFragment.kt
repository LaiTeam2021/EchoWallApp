package com.laiteam.echowall.ui.onboarding.login

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
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

        // error message
        viewModel.errorMessage.observe(this) { message ->
            binding.errorMessage.setText(message);
        }
        // sign up
        binding.register.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
        // editText textChangedListener
        binding.loginEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel._errorMessage.value = ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.loginPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel._errorMessage.value = ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        viewModel.loginInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS -> it.data?.let { data ->
                    userManager.onUserLogin(data)
                    startActivityAfterFinishThis(MainActivity::class.java)
                    viewModel._errorMessage.value = ""
                }
                Status.LOCAL_INVALID_INPUT -> it.let {
                    viewModel._errorMessage.value = getString(it.errorRes)
                    binding.errorMessage.startAnimation(AnimationUtils.loadAnimation(context, R.anim.edit_text_shake))

                }
                Status.ERROR -> it.let {
                    viewModel._errorMessage.value = it.message
                    binding.errorMessage.startAnimation(AnimationUtils.loadAnimation(context, R.anim.edit_text_shake))
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



