package com.laiteam.echowall.ui.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.laiteam.echowall.base.environment.Navigator
import com.laiteam.echowall.util.FragmentUtils

class FragmentNavigator(val fragment: Fragment): Navigator {
    override fun navigate(directions: NavDirections) {
        NavHostFragment.findNavController(fragment).navigate(directions)
    }

    override fun navigateFrom(directions: NavDirections, clazz: Class<*>) {
        var currentFragment = FragmentUtils.findFragmentOfType(fragment, clazz) as Fragment?
        currentFragment?.let {
            NavHostFragment.findNavController(currentFragment).navigate(directions)
        }
    }
}