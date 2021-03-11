package com.laiteam.echowall.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "user")
class User {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    var userId:Int = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null
}