package com.github.leventarican.underconstruction.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * definition of an interface of how to access the database.
 * Room will generate the SQL queries and other code.
 * Note that we return a LiveData. Room will care about the latest data.
 */
@Dao
interface DeveloperDao {

    @Insert
    fun insert(data: Developer)

    @Query("select * from developer_table order by id desc")
    fun getDevelopers(): LiveData<List<Developer>>
}