package com.laiteam.echowall.user

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.network.NetworkHeaderProvider
import com.laiteam.echowall.network.model.LoginModel
import com.laiteam.echowall.sharedpreference.Storage
import javax.inject.Inject
import javax.inject.Singleton

private const val SESSION = "session"
@Singleton
class UserManager @Inject constructor(
    private val userComponentFactory: UserComponent.Factory,
    private val storage: Storage,
    private val networkHeaderProvider: NetworkHeaderProvider
) {
    var userComponent: UserComponent? = null
        private set

    var loginModel: LoginModel? = null

    fun shouldAutoLogin(): Boolean {
        try {
            loginModel = Gson().fromJson(storage.getString(SESSION), LoginModel::class.java)
        } catch (e: JsonSyntaxException) {

        }
        return when (loginModel == null) {
            true -> {
                false
            }
            else -> {
                userComponent = userComponentFactory.create()
                true
            }
        }
    }

    fun onUserLogin(loginModel: LoginModel) {
        storage.setString(SESSION,  Gson().toJson(loginModel))
        networkHeaderProvider.token = loginModel.token
        userComponent = userComponentFactory.create()
    }

    fun onUserLogout(): Boolean {
        storage.setString(SESSION, null)
        networkHeaderProvider.token = null
        userComponent = null
        return true
    }
}