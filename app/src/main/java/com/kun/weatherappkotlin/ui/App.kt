package com.kun.weatherappkotlin.ui

import android.app.Application
import com.kun.weatherappkotlin.extensions.DelegatesExt

/**
 * @author liukepeng
 * @date 2019/1/5
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}