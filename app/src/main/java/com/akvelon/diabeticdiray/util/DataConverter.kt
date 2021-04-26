package com.akvelon.diabeticdiray.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DataConverter {
    companion object {
        @SuppressLint("SimpleDateFormat")
        fun currentDate(): String {
            val yourMilliSeconds = System.currentTimeMillis()
            val sdf = SimpleDateFormat("MMM dd,yyyy HH:mm")
            val resultDate = Date(yourMilliSeconds)
            return sdf.format(resultDate)
        }
    }
}
