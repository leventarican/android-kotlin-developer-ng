package com.github.leventarican.room.repository

import androidx.annotation.WorkerThread
import com.github.leventarican.room.room.ProgrammingLanguage
import com.github.leventarican.room.room.ProgrammingLanguageDao
import kotlinx.coroutines.flow.Flow

/**
 * delegate operations (query, insert, ...) to DAO
 */
class ProgrammingLanguageRepository(private val dao: ProgrammingLanguageDao) {

    val allLanguages: Flow<List<ProgrammingLanguage>> = dao.getAlphabetizedProgrammingLanguages()

    @WorkerThread
    suspend fun insert(language: ProgrammingLanguage) {
        dao.insert(language)
    }
}