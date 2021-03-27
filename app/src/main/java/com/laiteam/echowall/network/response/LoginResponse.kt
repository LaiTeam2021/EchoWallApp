package com.laiteam.echowall.network.response

data class LoginResponse(val token: String, val topics: List<Topic>)