package com.laiteam.echowall.base.environment

import androidx.navigation.NavDirections

interface Environment {

    fun navigate(direction: NavDirections)
}