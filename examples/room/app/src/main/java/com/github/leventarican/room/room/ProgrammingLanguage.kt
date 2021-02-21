package com.github.leventarican.room.room

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * add annotation to connect class and database for android room
 */
@Entity(tableName="programming_language")
data class ProgrammingLanguage(@ColumnInfo val language: String)