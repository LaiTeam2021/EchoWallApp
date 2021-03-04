package com.laiteam.echowall.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laiteam.echowall.room.dao.PersonDao
import com.laiteam.echowall.room.entity.Person


@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao?
}