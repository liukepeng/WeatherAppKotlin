package com.kun.weatherappkotlin.domain.commands

/**
 * @author liukepeng
 * @date 2019/1/5
 */
interface Command<out T> {
    fun execute(): T
}