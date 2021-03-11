package com.laiteam.echowall.di.application

import android.content.Context
import androidx.room.Room
import com.laiteam.echowall.di.ApplicationContext
import com.laiteam.echowall.di.DatabaseInfo
import com.laiteam.echowall.room.AppDatabase
import com.laiteam.echowall.room.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(@field:ApplicationContext @param:ApplicationContext private val context: Context) {

    @DatabaseInfo
    private val dbName = "testDatabase.db"

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return dbName
    }

    @Singleton
    @Provides
    fun providePersonDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

}