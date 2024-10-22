package com.laiteam.echowall.room.dao

import androidx.room.*


@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: List<T>)

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}