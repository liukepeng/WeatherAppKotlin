package com.kun.weatherappkotlin.extensions

import java.text.DateFormat
import java.util.*

/**
 * @author liukepeng
 * @date 2019/1/5
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}