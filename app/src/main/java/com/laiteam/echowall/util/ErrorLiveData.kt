package com.laiteam.echowall.util

import androidx.lifecycle.LiveData

class ErrorLiveData<T : Any?>(private val data: T) : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(data)
    }

    companion object {
        fun <T> create(data: T): LiveData<T> {
            return ErrorLiveData(data)
        }
    }
}