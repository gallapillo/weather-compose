package com.gallapillo.weathercompose.di

import com.gallapillo.weathercompose.data.local.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPI() : WeatherApi {
        return Retrofit.Builder()
            .baseUrl("url")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

}