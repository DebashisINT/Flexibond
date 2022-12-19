package com.flexibond.features.weather.api

import com.flexibond.base.BaseResponse
import com.flexibond.features.task.api.TaskApi
import com.flexibond.features.task.model.AddTaskInputModel
import com.flexibond.features.weather.model.ForeCastAPIResponse
import com.flexibond.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}