package com.laiteam.echowall.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHeaderProvider @Inject internal constructor() {
    var token: String? = null

}