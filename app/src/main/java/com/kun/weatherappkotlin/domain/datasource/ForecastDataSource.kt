package com.kun.weatherappkotlin.domain.datasource

import com.kun.weatherappkotlin.domain.model.Forecast
import com.kun.weatherappkotlin.domain.model.ForecastList

/**
 * @author liukepeng
 * @date 2019/1/5
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode:Long, date: Long):ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}
