package com.akvelon.diabeticdiray.ui.screen.addrecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.akvelon.diabeticdiray.database.RecordingDAO
import com.akvelon.diabeticdiray.model.RecordingEntity
import com.akvelon.diabeticdiray.util.DataConverter
import kotlinx.coroutines.*

class AddRecordViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addRecord(sugar: String, insulin: String, note: String) {
        uiScope.launch {
            val record = RecordingEntity(0L, DataConverter.currentDate(), sugar, insulin, note)
            insert(record)
        }
    }

    private suspend fun insert(record: RecordingEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(record)
        }
    }
}
