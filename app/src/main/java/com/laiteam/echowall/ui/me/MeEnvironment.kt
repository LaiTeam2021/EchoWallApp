package com.laiteam.echowall.ui.me

import com.laiteam.echowall.base.environment.HasNavigator
import com.laiteam.echowall.base.environment.HasUserManager
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.user.UserManager

class MeEnvironment(private val navigator: Navigator, private val userManager: UserManager) : HasNavigator, HasUserManager {
    override fun getNavigator() = navigator;

    override fun getUserManager() = userManager;
}