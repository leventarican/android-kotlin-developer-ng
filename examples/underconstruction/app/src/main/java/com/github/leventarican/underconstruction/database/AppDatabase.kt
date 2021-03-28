package com.github.leventarican.underconstruction.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Developer::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun developerDao(): DeveloperDao
}