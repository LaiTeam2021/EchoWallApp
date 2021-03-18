package com.laiteam.echowall.base.environment

import androidx.navigation.NavDirections
import kotlin.reflect.KClass

interface Navigator {

    fun navigate(directions: NavDirections);

    fun navigateFrom(directions: NavDirections, clazz: Class<*>)
}