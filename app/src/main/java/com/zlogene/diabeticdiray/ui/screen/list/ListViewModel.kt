package com.zlogene.diabeticdiray.ui.screen.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.zlogene.diabeticdiray.database.RecordingDAO
import com.zlogene.diabeticdiray.model.RecordingEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.random.Random

class ListViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {

    val records = dao.getAll()

    fun deleteAll() {
        viewModelScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            dao.clear()
        }
    }

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

    fun addTestData() {
        val list = listOf<RecordingEntity>(
            RecordingEntity(
                0L,
                getDate(2021, 4, 25, 4),
                (1..10).random().toFloat(),
                (1..10).random().toFloat(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                getDate(2021, 4, 26, 5),
                (1..10).random().toFloat(),
                (1..10).random().toFloat(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                getDate(2021, 4, 27, 13),
                (1..10).random().toFloat(),
                (1..10).random().toFloat(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                getDate(2021, 4, 11, 23),
                (1..10).random().toFloat(),
                (1..10).random().toFloat(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                getDate(2021, 4, 15, 11),
                (1..10).random().toFloat(),
                (1..10).random().toFloat(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
        )

        val iterator = list.listIterator()
        for (item in iterator) {
            addRecord(item)
        }
    }

    private fun getDate(year: Int, month: Int, day: Int, hour: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        return calendar.timeInMillis
    }
}
