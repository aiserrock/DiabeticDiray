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
    val weekStatSugar = getStatWeekSugar()
    val monthStatSugar = getStatMonthSugar()
    val quarterStatSugar = getStatQuarterSugar()
    val yearStatSugar = getStatYearSugar()


    //Insulin Live Data
    //val weekStatInsulin = getStatWeekInsulin ()
    //val monthStatInsulin  = getStatMonthInsulin ()
    //val quarterStatInsulin  = getStatQuarterInsulin ()
    //val yearStatInsulin  = getStatYearInsulin ()

    fun getStatWeekSugar() {
        viewModelScope.launch {
            statWeekSugar()
        }
    }

    private suspend fun statWeekSugar() {
        withContext(Dispatchers.IO) {
            dao.getWeekSugar()
        }
    }

    fun getStatMonthSugar() {
        viewModelScope.launch {
            statMonthSugar()
        }
    }

    private suspend fun statMonthSugar() {
        withContext(Dispatchers.IO) {
            dao.getMonthSugar()
        }
    }

    fun getStatQuarterSugar() {
        viewModelScope.launch {
            statQuarterSugar()
        }
    }

    private suspend fun statQuarterSugar() {
        withContext(Dispatchers.IO) {
            dao.getQuarterSugar()
        }
    }

    fun getStatYearSugar() {
        viewModelScope.launch {
            statYearSugar()
        }
    }

    private suspend fun statYearSugar() {
        withContext(Dispatchers.IO) {
            dao.getYearSugar()
        }
    }

//    // Insulin
//
//    fun getStatWeekInsulin() {
//        viewModelScope.launch {
//            statWeekInsulin()
//        }
//    }
//    private suspend fun statWeekInsulin() {
//        withContext(Dispatchers.IO) {
//            dao.getWeekInsulin()
//        }
//    }
//
//    fun getStatMonthInsulin() {
//        viewModelScope.launch {
//            statMonthInsulin()
//        }
//    }
//    private suspend fun statMonthInsulin() {
//        withContext(Dispatchers.IO) {
//            dao.getMonthInsulin()
//        }
//    }
//
//    fun getStatQuarterInsulin() {
//        viewModelScope.launch {
//            statQuarterInsulin()
//        }
//    }
//    private suspend fun statQuarterInsulin() {
//        withContext(Dispatchers.IO) {
//            dao.getQuarterInsulin()
//        }
//    }
//
//    fun getStatYearInsulin() {
//        viewModelScope.launch {
//            statYearInsulin()
//        }
//    }
//    private suspend fun statYearInsulin() {
//        withContext(Dispatchers.IO) {
//            dao.getYearInsulin()
//        }
//    }
}