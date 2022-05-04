package com.gallapillo.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.gallapillo.weathercompose.presentation.MainWeather
import com.gallapillo.weathercompose.presentation.theme.BackgroundColor
import com.gallapillo.weathercompose.presentation.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = BackgroundColor, modifier = Modifier.fillMaxSize()) {
                    MainWeather()
                }
            }
        }
    }
}
