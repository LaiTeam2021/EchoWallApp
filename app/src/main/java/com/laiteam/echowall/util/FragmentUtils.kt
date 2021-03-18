package com.laiteam.echowall.util

import androidx.fragment.app.Fragment

class FragmentUtils {
    companion object {


        fun <T> findFragmentOfType(
            fragment: Fragment, clazz: Class<out T>
        ): T? {
            var findFragment : Fragment? = fragment
            while (findFragment != null)
            {
                if (clazz == findFragment.javaClass) {
                    return findFragment as T
                }
                val primaryNavFragment: Fragment? = findFragment.parentFragmentManager.primaryNavigationFragment
                if (clazz == findFragment.javaClass) {
                    return primaryNavFragment as T
                }
                findFragment = findFragment.parentFragment
            }
            return findFragment as T
        }
    }


}