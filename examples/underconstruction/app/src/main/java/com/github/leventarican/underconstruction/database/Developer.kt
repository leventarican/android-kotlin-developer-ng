package com.github.leventarican.underconstruction.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "developer_table")
data class Developer(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "experience")
    var exp: Int = 0,
    var timestamp: Long = System.currentTimeMillis()
)
