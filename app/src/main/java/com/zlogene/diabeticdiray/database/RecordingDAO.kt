package com.zlogene.diabeticdiray.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.zlogene.diabeticdiray.model.RecordingEntity
import java.util.*

@Dao
interface RecordingDAO {
    @Insert
    fun insert(recording: RecordingEntity)

    @Update
    fun update(recording: RecordingEntity)

    @Delete
    fun delete(recording: RecordingEntity)

    @Query("DELETE FROM recording_table")
    fun clear()

    @Query("SELECT * FROM recording_table ORDER BY date")
    fun getAll(): LiveData<MutableList<RecordingEntity>>

    @Query("SELECT * FROM recording_table WHERE date BETWEEN date('now') AND date('now','-7 days') ORDER BY sugar")
    fun getWeekSugar(): LiveData<MutableList<RecordingEntity>>

    @Query("SELECT * FROM recording_table ORDER BY date")
    fun getMonthSugar(): LiveData<MutableList<RecordingEntity>>

    @Query("SELECT * FROM recording_table ORDER BY date")
    fun getQuarterSugar(): LiveData<MutableList<RecordingEntity>>

    @Query("SELECT * FROM recording_table ORDER BY date")
    fun getYearSugar(): LiveData<MutableList<RecordingEntity>>
}
