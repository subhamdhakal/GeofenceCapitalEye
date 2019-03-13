package com.example.capitaleyegeofence

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun Long.getFormattedStringFromTimeStamp(): String {
    val simpleDateFormat = SimpleDateFormat("d MMMM yyyy")
    val calendar = Calendar.getInstance()
    calendar.time = Date(this)
    val strDate = simpleDateFormat.format(calendar.time)
    var daySuffix = " "
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    if (dayOfMonth > 3 && dayOfMonth < 21)
        daySuffix = "th "
    else {
        when (dayOfMonth % 10) {
            1 -> daySuffix = "st "
            2 -> daySuffix = "nd "
            3 -> daySuffix = "rd "
            else -> daySuffix = "th "
        }
    }
    return strDate.replaceFirst(" ".toRegex(), daySuffix)
}

