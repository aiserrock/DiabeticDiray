package com.akvelon.diabeticdiray.ui.screen.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.akvelon.diabeticdiray.database.RecordingDAO
import com.akvelon.diabeticdiray.model.RecordingEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val records = dao.getAll()

    fun onAddButtonPressed() {
        uiScope.launch {
            val newRecord = RecordingEntity()
            insert(newRecord)
        }
    }

    private suspend fun insert(recording: RecordingEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(recording)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
