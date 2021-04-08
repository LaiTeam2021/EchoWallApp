package com.laiteam.echowall.room

import android.database.sqlite.SQLiteDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseConnectionProvider
import java.io.File

class DatabaseConnectionProvider (
    private val passwordProvider: (databaseFile: File) -> String): SqliteDatabaseConnectionProvider {
        override fun openDatabase(databaseFile: File): SupportSQLiteDatabase? =
                SQLiteDatabase.openDatabase(
                        databaseFile.absolutePath,
                        passwordProvider(databaseFile),
                        null,
                        SQLiteDatabase.OPEN_READWRITE
                )
    }

