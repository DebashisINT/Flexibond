package com.flexibond.features.weather.api

import com.flexibond.features.task.api.TaskApi
import com.flexibond.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}