package com.github.leventarican.room.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * add annotation to connect class and database for android room
 */
@Entity(tableName="programming_language")
data class ProgrammingLanguage(@PrimaryKey @ColumnInfo val language: String)