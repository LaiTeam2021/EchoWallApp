package com.laiteam.echowall.network.response

data class NetworkResponse<out T>(val status: Status, val data: T? = null, val message: String? = null, val errorRes: Int = 0) {
    companion object {
        fun <T> success(data: T?): NetworkResponse<T> {
            return NetworkResponse(Status.SUCCESS, data)
        }

        fun <T> error(msg: String, data: T?): NetworkResponse<T> {
            return NetworkResponse(Status.ERROR, data)
        }

        fun <T> localError(msgRes: Int) : NetworkResponse<T> {
            return NetworkResponse(Status.LOCAL_ERROR, errorRes = msgRes)
        }

        fun <T> loading(data: T?): NetworkResponse<T> {
            return NetworkResponse(Status.LOADING, data)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOCAL_ERROR,
    LOADING
}
