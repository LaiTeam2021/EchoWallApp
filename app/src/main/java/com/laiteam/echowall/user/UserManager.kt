package com.laiteam.echowall.user

import com.laiteam.echowall.di.user.UserComponent
import com.laiteam.echowall.sharedpreference.Storage
import javax.inject.Inject
import javax.inject.Singleton

private const val SESSION = "session"

@Singleton
class UserManager @Inject constructor(
    private val userComponentFactory: UserComponent.Factory,
    private val storage: Storage
) {
    var userComponent: UserComponent? = null
        private set

    val isUserLoggedIn: Boolean
        get() = userComponent != null

    fun shouldAutoLogin(): Boolean {
        val sessionName = storage.getString(SESSION)
        return when (sessionName.isNullOrBlank()) {
            true -> {
                false
            }
            else -> {
                userComponent = userComponentFactory.create()
                true
            }
        }
    }

    fun onUserLogin(userName: String?) {
        storage.setString(SESSION, userName!!)
        userComponent = userComponentFactory.create()
    }

    fun onUserLogout(): Boolean {
        storage.setString(SESSION, null)
        userComponent = null
        return true
    }
}