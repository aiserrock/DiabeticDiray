package com.zlogene.diabeticdiray.ui.screen.graph

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zlogene.diabeticdiray.database.RecordingDAO
import java.util.*

class GraphViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {

    val records = dao.getAll()
}
