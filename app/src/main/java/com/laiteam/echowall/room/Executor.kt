package com.laiteam.echowall.room

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
 *  Use Executor as following way.
 *  Executor.IOThread(() -> personDao.insert(new Person()));
 */
object Executor {
    fun IOThread(t: Runnable?) {
        val IO_EXECUTOR: ExecutorService = Executors.newSingleThreadExecutor()
        IO_EXECUTOR.execute(t)
    }
}