package com.breezefieldflexibond.features.weather.api

import com.breezefieldflexibond.features.task.api.TaskApi
import com.breezefieldflexibond.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}