package com.laiteam.echowall.room.dao

import androidx.room.*


@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T): Long

    @Update
    fun update(t: T): Boolean

    @Delete
    fun delete(t: T): Boolean
}