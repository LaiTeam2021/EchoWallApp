package com.laiteam.echowall.base.environment

import androidx.navigation.NavController

interface HasNavigator {

    fun getNavigator(): NavController
}