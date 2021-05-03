package com.zlogene.diabeticdiray.ui.screen.addrecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zlogene.diabeticdiray.database.RecordingDAO
import com.zlogene.diabeticdiray.model.RecordingEntity
import kotlinx.coroutines.*
import java.util.*

class AddRecordViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addRecord(sugar: String, insulin: String, note: String) {
        uiScope.launch {
            val calendar = Calendar.getInstance()
            val record = RecordingEntity(0L, calendar.timeInMillis, sugar.toFloat(), insulin.toFloat(), note)
            insert(record)
        }
    }

    private suspend fun insert(record: RecordingEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(record)
        }
    }
}
