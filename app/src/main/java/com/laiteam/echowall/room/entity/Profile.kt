package com.laiteam.echowall.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class Profile(@PrimaryKey val username: String) {
}