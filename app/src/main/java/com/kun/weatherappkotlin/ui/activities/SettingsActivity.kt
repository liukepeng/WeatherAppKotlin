package com.kun.weatherappkotlin.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kun.weatherappkotlin.R

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val ZIP_CODE = "zipCode"
        const val DEFAULT_ZIP = 94043L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}
