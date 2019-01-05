package com.kun.weatherappkotlin.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * @author liukepeng
 * @date 2019/1/5
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)