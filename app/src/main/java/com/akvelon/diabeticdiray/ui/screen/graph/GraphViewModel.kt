package com.akvelon.diabeticdiray.ui.screen.graph

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.akvelon.diabeticdiray.database.RecordingDatabase
import java.util.*

class GraphViewModel(
    application: Application
) : AndroidViewModel(application) {
    companion object {
        const val HOUR24 = 86400000L // 24 hours in mills
    }
    // TODO its not good idea, exist
    // calendar.time , we can store time in string it database
    // refactor it
    private val dao = RecordingDatabase.getInstance(application).getRecordingDatabaseDao()
    // Get records for the last 24 hours
    val timeNowInMills = Calendar.getInstance().timeInMillis
    val records24hour = dao.getAllFor24Hours(timeNowInMills, timeNowInMills - HOUR24)
}
