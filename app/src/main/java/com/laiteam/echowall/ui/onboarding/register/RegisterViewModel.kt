package com.laiteam.echowall.ui.onboarding.register

import com.laiteam.echowall.user.UserManager
import javax.inject.Inject

class RegisterViewModel (val userManager: UserManager){
    private var username: String? = null
    private var password: String? = null

    fun registerUser() {
        assert(username != null)
        assert(password != null)

        userManager.registerUser(username!!, password!!)
    }
}