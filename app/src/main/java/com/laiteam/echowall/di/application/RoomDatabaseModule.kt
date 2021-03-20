package com.laiteam.echowall.di.application

import android.app.Application
import androidx.room.Room
import com.laiteam.echowall.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


private const val dbName = "echo_wall_db"
@Module
class RoomDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
                application,
            AppDatabase::class.java,
            dbName
        ).build()
    }

}