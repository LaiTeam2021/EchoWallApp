package com.laiteam.echowall.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.laiteam.echowall.room.entity.User


@Dao
interface UserDao : BaseDao<User?> {
    @get:Query("SELECT * FROM user")
    val all: List<Any?>?

    @Query("SELECT * FROM user WHERE name LIKE :name")
    fun findPersonsByName(name: String?): List<User?>?
}