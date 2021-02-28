package com.laiteam.echowall.base

import androidx.lifecycle.ViewModel

open class BaseViewModel(private val baseRepository: BaseRepository? = null): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        baseRepository?.onCleared()
    }
}