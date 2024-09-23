package com.breezefieldflexibond.features.weather.api

import com.breezefieldflexibond.base.BaseResponse
import com.breezefieldflexibond.features.task.api.TaskApi
import com.breezefieldflexibond.features.task.model.AddTaskInputModel
import com.breezefieldflexibond.features.weather.model.ForeCastAPIResponse
import com.breezefieldflexibond.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}