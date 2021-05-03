package com.zlogene.diabeticdiray.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName
import com.zlogene.diabeticdiray.database.DateConverter
import java.util.*

@Parcelize
@Entity(tableName = "recording_table")
data class RecordingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var recordingId: Long = 0L,

    @ColumnInfo(name = "date")
    @SerializedName("date")
    @TypeConverters(DateConverter::class)
    var date: Date,

    @ColumnInfo(name = "sugar")
    var sugar: Float,

    @ColumnInfo(name = "insulin")
    var insulin: Float,

    @ColumnInfo(name = "textNote")
    var textNote: String
) : Parcelable
