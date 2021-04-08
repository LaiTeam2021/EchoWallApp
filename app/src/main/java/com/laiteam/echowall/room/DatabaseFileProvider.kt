package com.laiteam.echowall.room

import android.content.Context
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseProvider
import java.io.File

class DatabaseFileProvider(private val context: Context) : SqliteDatabaseProvider {

    override fun getDatabaseFiles(): MutableList<File> =
            context.databaseList()
                    .map(context::getDatabasePath)
                    .toMutableList() // or, just manually created list of your DB files.
}