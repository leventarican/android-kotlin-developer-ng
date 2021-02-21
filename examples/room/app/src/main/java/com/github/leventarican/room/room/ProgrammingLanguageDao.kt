package com.github.leventarican.room.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * usage of Flow for db observation / queries;
 * this Flow data type will be transformed to LiveData;
 * with Flow queries are automatically run asynchronously on a background thread
 */
@Dao
interface ProgrammingLanguageDao {
    @Query("SELECT * FROM programming_language ORDER BY language ASC")
    fun getAlphabetizedProgrammingLanguages(): Flow<List<ProgrammingLanguage>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(programmingLanguage: ProgrammingLanguage)

    @Query("DELETE FROM programming_language")
    suspend fun deleteAll()
}
