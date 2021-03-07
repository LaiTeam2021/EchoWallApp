package com.laiteam.echowall.ui.onboarding.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.laiteam.echowall.base.BaseViewModel
import com.laiteam.echowall.network.model.LoginInfo
import com.laiteam.echowall.network.request.LoginRequestBody
import com.laiteam.echowall.network.response.NetworkResponse
import com.laiteam.echowall.util.ErrorLiveData
import javax.inject.Inject

private const val REGULAR_EXPRESSION = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+\$"
class LoginViewModel @Inject constructor(loginRepository: LoginRepository) : BaseViewModel() {
    var _passwordVisible = MutableLiveData(false)

    fun togglePasswordVisible() {
        _passwordVisible.value = !_passwordVisible.value!!
    }

    val passwordVisible: LiveData<Boolean>
        get() = _passwordVisible

    private val loginRequestBody = MutableLiveData<LoginRequestBody>()
    fun setLogin(email: String, password: String) {
        loginRequestBody.value =
            LoginRequestBody(
                email,
                password
            )
    }

    val loginInfo: LiveData<NetworkResponse<LoginInfo>> =
        loginRequestBody.switchMap { loginRequestBody ->
            if (loginRequestBody.email.matches(Regex(REGULAR_EXPRESSION))) {
                ErrorLiveData.create(NetworkResponse.error("invalid email", null))
            } else if (loginRequestBody.password.length < 6) {
                ErrorLiveData.create(NetworkResponse.error("password must be at least 6 characters", null))
            } else {
                loginRepository.loadLoginInfo(loginRequestBody)
            }

        }
}