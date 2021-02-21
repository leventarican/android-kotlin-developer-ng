package com.github.leventarican.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ProgrammingLanguage::class), version = 1, exportSchema = false)
abstract class ProgrammingLanguageRoomDatabase : RoomDatabase() {

    abstract fun programmingLanguage(): ProgrammingLanguageDao

    companion object {
        // ensure that one instance of database at same time exists
        @Volatile
        private var INSTANCE: ProgrammingLanguageRoomDatabase? = null

        fun getDatabase(context: Context): ProgrammingLanguageRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProgrammingLanguageRoomDatabase::class.java,
                    "programming_language_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
}