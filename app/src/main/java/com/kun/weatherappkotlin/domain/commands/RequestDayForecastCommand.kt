package com.kun.weatherappkotlin.domain.commands

import com.kun.weatherappkotlin.domain.datasource.ForecastProvider
import com.kun.weatherappkotlin.domain.model.Forecast

/**
 * @author liukepeng
 * @date 2019/1/5
 */
class RequestDayForecastCommand(
    val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) :
        Command<Forecast> {

    override fun execute() =
        forecastProvider.requestForecast(id)
}