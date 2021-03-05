package com.laiteam.echowall.base.environment

import com.laiteam.echowall.user.UserManager

interface HasUserManager {

    fun getUserManager(): UserManager
}