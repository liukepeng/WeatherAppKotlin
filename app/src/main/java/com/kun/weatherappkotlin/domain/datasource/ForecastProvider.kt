package com.kun.weatherappkotlin.domain.datasource

import com.antonioleiva.weatherapp.data.server.ForecastServer
import com.kun.weatherappkotlin.data.db.ForecastDb
import com.kun.weatherappkotlin.domain.model.Forecast
import com.kun.weatherappkotlin.domain.model.ForecastList
import com.kun.weatherappkotlin.extensions.firstResult

/**
 * @author liukepeng
 * @date 2019/1/5
 */
class ForecastProvider(private val source: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer())}
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources {
        it.requestDayForecast(id)
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = source.firstResult { f(it) }
}