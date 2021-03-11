package com.laiteam.echowall.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laiteam.echowall.room.dao.UserDao
import com.laiteam.echowall.room.entity.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}