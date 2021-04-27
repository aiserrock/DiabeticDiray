package com.akvelon.diabeticdiray.util

import java.text.SimpleDateFormat

class DataConverter {
    companion object {
        fun convertFromTimeMills(timeMills: Long): String? {
            val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            return formatter.format(timeMills)
        }
    }
}
