package com.zlogene.diabeticdiray.ui.screen.graph

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zlogene.diabeticdiray.database.RecordingDatabase
import java.util.*

class GraphViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()

    val records = dao.getAll()
}
