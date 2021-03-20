package com.laiteam.echowall.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.laiteam.echowall.room.entity.Profile

@Database(entities = [Profile::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

}