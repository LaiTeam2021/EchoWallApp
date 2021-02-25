package com.laiteam.echowall.sharedpreference

interface Storage {
    fun setString(key: String, value: String?)
    fun getString(key: String): String?
}