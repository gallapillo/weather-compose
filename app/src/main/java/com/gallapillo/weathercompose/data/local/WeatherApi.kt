package com.gallapillo.weathercompose.data.local

import com.gallapillo.weathercompose.common.ApiKey.API_KEY
import com.gallapillo.weathercompose.data.local.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeatherFromCity(
        @Query("q") q : String,
        @Query("appid") appid: String = API_KEY
    ) : WeatherDto
}