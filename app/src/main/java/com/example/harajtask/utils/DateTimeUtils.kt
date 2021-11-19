package com.example.harajtask.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    fun formatCarDate(dateInLong:Long) : String{
        val df = SimpleDateFormat("dd-MMM-yyyy hh:mm a")
        val date = Date(dateInLong)
        return df.format(date)
    }
}