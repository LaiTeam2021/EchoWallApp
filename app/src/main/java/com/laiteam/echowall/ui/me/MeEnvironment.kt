package com.laiteam.echowall.ui.me

import androidx.navigation.NavController
import com.laiteam.echowall.base.environment.HasNavigator
import com.laiteam.echowall.base.environment.HasUserManager
import com.laiteam.echowall.user.UserManager

class MeEnvironment(private val navController: NavController, private val userManager: UserManager) : HasNavigator, HasUserManager {
    override fun getNavigator() = navController;

    override fun getUserManager() = userManager;
}