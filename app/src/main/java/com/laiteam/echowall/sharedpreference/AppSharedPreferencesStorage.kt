package com.laiteam.echowall.sharedpreference

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.laiteam.echowall.App.Companion.SHARED_PREFERENCE
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSharedPreferencesStorage @Inject internal constructor(application: Application) : Storage {
    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)


    override fun setString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}