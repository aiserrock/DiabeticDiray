package com.zlogene.diabeticdiray.ui.screen.statistics

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zlogene.diabeticdiray.database.RecordingDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class StatisticsViewModel(
    val dao: RecordingDAO,
    application: Application
) : AndroidViewModel(application) {
    val calendar = Calendar.getInstance()

    // Sugar Live Data
    val weekStatSugar = dao.getWeekSugar()
    val weekAVGSugar = dao.getAVGWeekSugar()

    val monthStatSugar = dao.getMonthSugar()
    val monthAVGSugar = dao.getAVGMonthSugar()

    val quarterStatSugar = dao.getQuarterSugar()
    val quarterAVGSugar = dao.getAVGQuarterSugar()

    val yearStatSugar = dao.getYearSugar()
    val yearAVGSugar = dao.getAVGYearSugar()


    //Insulin Live Data
    val weekStatInsulin = dao.getWeekInsulin()
    val weekAVGInsulin = dao.getAVGWeekInsulin()

    val monthStatInsulin  = dao.getMonthInsulin()
    val monthAVGInsulin = dao.getAVGMonthInsulin()

    val quarterStatInsulin  = dao.getQuarterInsulin()
    val quarterAVGInsulin = dao.getAVGQuarterInsulin()

    val yearStatInsulin  = dao.getYearInsulin()
    val yearAVGInsulin = dao.getAVGYearInsulin()


}