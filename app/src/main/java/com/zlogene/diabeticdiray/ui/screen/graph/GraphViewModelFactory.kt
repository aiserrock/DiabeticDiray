package com.zlogene.diabeticdiray.ui.screen.graph

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zlogene.diabeticdiray.database.RecordingDAO
import com.zlogene.diabeticdiray.ui.screen.list.ListViewModel
import java.lang.IllegalArgumentException

class GraphViewModelFactory(
    private val dao: RecordingDAO,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GraphViewModel::class.java)) {
            return GraphViewModel(dao, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}