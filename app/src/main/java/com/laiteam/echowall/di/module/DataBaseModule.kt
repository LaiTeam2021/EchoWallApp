package com.laiteam.echowall.di.module

import androidx.room.Room
import com.laiteam.echowall.room.AppDatabase
import com.laiteam.echowall.room.dao.PersonDao
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(@ApplicationContext context: Context) {
    @ApplicationContext
    private val mContext: Context

    @DatabaseInfo
    private val mDBName = "test_database.db"

    @Singleton
    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            mContext,
            AppDatabase::class.java,
            mDBName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return mDBName
    }

    @Singleton
    @Provides
    fun providePersonDao(db: AppDatabase): PersonDao? {
        return db.personDao()
    }


    init {
        mContext = context
    }
}