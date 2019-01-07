package com.kun.weatherappkotlin.domain.commands

import com.kun.weatherappkotlin.domain.datasource.ForecastProvider
import com.kun.weatherappkotlin.domain.model.ForecastList

/**
 * @author liukepeng
 * @date 2019/1/5
 */
class RequestForecastCommand(
    private val zipCode: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
): Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute() =
        forecastProvider.requestByZipCode(zipCode, DAYS)

}