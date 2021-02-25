package com.laiteam.echowall.network.response

sealed class NetworkResponse<out T>

// By using Nothing as T, Loading is a subtype of all NetworkResult<T>
object Loading : NetworkResponse<Nothing>()

// Successful results are stored in data
data class Success<out T>(val data: T) : NetworkResponse<T>()

// By using Nothing as T, all NetworkError instances are a subtypes of all NetworkResults<T>
data class Error(val exception: Throwable) : NetworkResponse<Nothing>()