package com.laiteam.echowall.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.laiteam.echowall.room.entity.Person


@Dao
interface PersonDao : BaseDao<Person?> {
    @get:Query("SELECT * FROM TB_PERSON")
    val all: List<Any?>?

    @Query("SELECT * FROM TB_PERSON WHERE name LIKE :name")
    fun findPersonsByName(name: String?): List<Person?>?
}