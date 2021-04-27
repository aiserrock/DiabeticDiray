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

    // convert normal data to timeMilss:
    // https://codechi.com/dev-tools/date-to-millisecond-calculators/

    fun insertTestingData() {
        val list = listOf<RecordingEntity>(
            RecordingEntity(
                0L,
                1619160300000L,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619509500000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619516700000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619552700000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619480700000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619207100000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1618911900000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619610000000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1619728800000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1616870400000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1622144400000,
                (1..10).random().toString(),
                (1..10).random().toString(),
                "All " + arrayOf("Good", "Bad", "Normal")[Random.nextInt(3)]
            ),
            RecordingEntity(
                0L,
                1637970000000,
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
