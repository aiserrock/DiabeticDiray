package com.akvelon.diabeticdiray

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.akvelon.diabeticdiray.database.RecordingDatabase
import com.akvelon.diabeticdiray.model.RecordingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()

    val records = dao.getAll()

    fun addRecord(record: RecordingEntity) {
        viewModelScope.launch {
            insert(record)
        }
    }

    private suspend fun insert(record: RecordingEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(record)
        }
    }

    fun insertTestingData() {
        val list = listOf<RecordingEntity>(
            RecordingEntity(
                0L,
                "Apr 27,2021 22:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 27,2021 23:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 27,2021 12:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 27,2021 10:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 25,2021 22:51",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 23,2021 21:21",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 20,2021 12:11",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 28,2021 14:00",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Apr 29,2021 23:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Mar 27,2021 22:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "May 27,2021 22:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                "Nov 27,2021 22:31",
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
        )

        val iterator = list.listIterator()
        for (item in iterator) {
            addRecord(item)
        }
    }
}
