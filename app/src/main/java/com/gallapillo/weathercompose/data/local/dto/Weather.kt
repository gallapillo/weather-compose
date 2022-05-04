package com.gallapillo.weathercompose.data.local.dto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)