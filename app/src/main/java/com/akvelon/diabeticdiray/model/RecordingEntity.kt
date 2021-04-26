package com.akvelon.diabeticdiray.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recording_table")
data class RecordingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var recordingId: Long = 0L,

    @ColumnInfo(name = "date")
    var date: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "sugar")
    var sugar: String = "Sugar",

    @ColumnInfo(name = "insulin")
    var insulin: String = "Insulin",

    @ColumnInfo(name = "textNote")
    var textNote: String = "TextNote"
)
