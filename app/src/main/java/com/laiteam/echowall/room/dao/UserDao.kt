package com.laiteam.echowall.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.laiteam.echowall.room.entity.User


@Dao
interface UserDao : BaseDao<User> {


    @Query("SELECT * FROM user WHERE name LIKE :name")
    fun findUserByName(name: String): List<User>
}