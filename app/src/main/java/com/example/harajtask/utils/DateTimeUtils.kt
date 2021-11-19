package com.example.harajtask.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {
    fun formatCarDate(dateInLong:Long) : String{
        val df = SimpleDateFormat("yyyy/MM/dd hh:mma")
        val date = Date(dateInLong)
        return df.format(date)
    }
}