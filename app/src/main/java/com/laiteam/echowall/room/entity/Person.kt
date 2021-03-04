package com.laiteam.echowall.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey


@Entity(tableName = "TB_PERSON")
class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    var person_id = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null
}