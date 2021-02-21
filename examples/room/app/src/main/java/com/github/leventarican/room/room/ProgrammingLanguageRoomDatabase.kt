package com.github.leventarican.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(ProgrammingLanguage::class), version = 1, exportSchema = false)
abstract class ProgrammingLanguageRoomDatabase : RoomDatabase() {

    abstract fun programmingLanguageDao(): ProgrammingLanguageDao

    companion object {
        // ensure that one instance of database at same time exists
        @Volatile
        private var INSTANCE: ProgrammingLanguageRoomDatabase? = null

        // use coroutine to run room database operations other thread instead of UI thread
        fun getDatabase(context: Context, scope: CoroutineScope): ProgrammingLanguageRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, ProgrammingLanguageRoomDatabase::class.java, "programming_language_database")
                        .addCallback(ProgrammingLanguageCallback(scope))
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    class ProgrammingLanguageCallback(private val scope: CoroutineScope) : Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let {
                scope.launch {
                    val dao = it.programmingLanguageDao()
                    dao.deleteAll()

                    var pl = ProgrammingLanguage(language = "Java")
                    dao.insert(pl)

                    pl = ProgrammingLanguage(language = "Koltin")
                    dao.insert(pl)

                    pl = ProgrammingLanguage(language = "Rust")
                    dao.insert(pl)
                }
            }
        }
    }
}