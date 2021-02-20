package com.github.leventarican.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ProgrammingLanguage::class), version = 1, exportSchema = false)
abstract class DeveloperRoomDatabase : RoomDatabase() {

    abstract fun programmingLanguage(): ProgrammingDao

    companion object {
        // ensure that one instance of database at same time exists
        @Volatile
        private var INSTANCE: DeveloperRoomDatabase? = null

        fun getDatabase(context: Context): DeveloperRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DeveloperRoomDatabase::class.java,
                    "programming_language_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
}