package com.laiteam.echowall.ui.onboarding.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.laiteam.echowall.R
import com.laiteam.echowall.base.BaseViewModel
import com.laiteam.echowall.network.model.LoginModel
import com.laiteam.echowall.network.response.LoginResponse
import com.laiteam.echowall.network.request.LoginRequestBody
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.util.ErrorLiveData
import javax.inject.Inject

private const val EMAIL_REGULAR_EXPRESSION = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+\$"
private const val DEFAULT_PASSWORD_MINIMUM_LENGTH = 6
class LoginViewModel @Inject constructor(loginRepository: LoginRepository) : BaseViewModel() {
    var _passwordVisible = MutableLiveData(false)
    var _errorMessage = MutableLiveData<String>(null)

    fun togglePasswordVisible() {
        _passwordVisible.value = !_passwordVisible.value!!
    }

    val passwordVisible: LiveData<Boolean>
        get() = _passwordVisible
    val errorMessage: LiveData<String>
        get() = _errorMessage

    val loginRequestBody = MutableLiveData<LoginRequestBody>()
    fun setLogin(email: String, password: String) {
        loginRequestBody.value =
            LoginRequestBody(
                email,
                password
            )
    }

    val loginInfo: LiveData<NetworkResponse<LoginModel>> =
        loginRequestBody.switchMap { loginRequestBody ->
            if (!loginRequestBody.email.matches(Regex(EMAIL_REGULAR_EXPRESSION))) {
                ErrorLiveData.create(NetworkResponse.localError(R.string.invalid_email_error))
            } else if (loginRequestBody.password.length < DEFAULT_PASSWORD_MINIMUM_LENGTH) {
                ErrorLiveData.create(NetworkResponse.localError(R.string.invalid_password_error))
            } else {
                loginRepository.loadLoginInfo(loginRequestBody)
            }

        }
}