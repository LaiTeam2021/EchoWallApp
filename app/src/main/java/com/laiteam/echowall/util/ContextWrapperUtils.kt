package com.laiteam.echowall.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

class ContextWrapperUtils {

    companion object {

        /**
         * Unwraps the given Context until it finds the root base [Context]. Useful for finding the
         * root when you don't know the Class type (like whether you're in an Activity or a Service).
         *
         * @param context Potentially wrapped Context
         * @return the most base Context
         */
        fun getRootBaseContext(context: Context): Context {
            var baseContext = context
            while (baseContext is ContextWrapper) {
                baseContext = baseContext.baseContext
            }
            return baseContext
        }

        /**
         * Returns the nearest context in the chain (as defined by ContextWrapper.getBaseContext()) which
         * is an instance of the specified type, or null if one could not be found
         *
         * @param context Initial context
         * @param clazz Class instance to look for
         * @param <T>
         * @return the first context which is an instance of the specified class, or null if none exists
        </T> */
        fun <T> findContextOfType(
            context: Context?, clazz: Class<out T>
        ): T? {
            var context = context as Context
            while (!clazz.isInstance(context)) {
                context = if (context is ContextWrapper) {
                    val baseContext = context.baseContext
                    if (context === baseContext) {
                        return null
                    } else {
                        baseContext
                    }
                } else {
                    return null
                }
            }
            return context as T?
        }

        /**
         * Returns the context for service binding. Usually it shall be the activity itself. For activity
         * which is launched by a [LocalActivityManager], it shall be the parent activity.
         */
        fun findContextForService(context: Context): Context {
            if (context is Activity) {
                val activity = context
                if (activity.parent != null) {
                    return activity.parent
                }
            }
            return context
        }
    }
}