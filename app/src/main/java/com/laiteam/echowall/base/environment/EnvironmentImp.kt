package com.laiteam.echowall.base.environment

import androidx.navigation.NavController
import androidx.navigation.NavDirections

class EnvironmentImp(private val navController: NavController) : Environment {
    override fun navigate(direction: NavDirections) {
        navController.navigate(direction)
    }
}