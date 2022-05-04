package com.gallapillo.weathercompose.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = OnPrimaryColor,
    secondary = SecondaryColor,
    background = BackgroundColor
)


@Composable
fun WeatherComposeTheme(
    content: @Composable() () -> Unit
) {

    rememberSystemUiController().setSystemBarsColor(
        color = OnPrimaryColor,
        darkIcons = false
    )

    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}