package com.akvelon.diabeticdiray.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "recording_table")
data class RecordingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var recordingId: Long = 0L,

    @ColumnInfo(name = "date")
    var date: Long,

    @ColumnInfo(name = "sugar")
    var sugar: String,

    @ColumnInfo(name = "insulin")
    var insulin: String,

    @ColumnInfo(name = "textNote")
    var textNote: String
) : Parcelable
