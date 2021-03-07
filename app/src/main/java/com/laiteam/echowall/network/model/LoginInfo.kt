package com.laiteam.echowall.network.model

import java.util.*

data class LoginInfo(val id: Long, val username: String, val email: String, val createDate: String, val token: String, val isActive: Boolean)