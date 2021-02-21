package com.github.leventarican.room

import android.app.Application
import com.github.leventarican.room.repository.ProgrammingLanguageRepository
import com.github.leventarican.room.room.ProgrammingLanguageRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * create database and repository when its needed rather then application starts;
 * this is achieved by using lazy;
 *
 * register application in manifest file;
 * ```
 * android:name=".ProgrammingLanguageApplication"
 * ``
 */
class ProgrammingLanguageApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ProgrammingLanguageRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ProgrammingLanguageRepository(database.programmingLanguageDao()) }

}