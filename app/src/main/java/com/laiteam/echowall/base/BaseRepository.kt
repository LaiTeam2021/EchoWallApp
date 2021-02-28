package com.laiteam.echowall.base

import kotlinx.coroutines.SupervisorJob

open class BaseRepository {

    protected val coroutineJob = SupervisorJob();

    fun onCleared() {
        coroutineJob.cancel();
    }
}