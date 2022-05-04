package com.gallapillo.weathercompose.domain.repository

import com.gallapillo.weathercompose.data.local.dto.WeatherDto

interface WeatherRepository {
    suspend fun getWeather(): WeatherDto
}