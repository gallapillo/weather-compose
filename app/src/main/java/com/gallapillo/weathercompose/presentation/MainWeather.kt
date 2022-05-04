package com.gallapillo.weathercompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gallapillo.weathercompose.R
import com.gallapillo.weathercompose.presentation.theme.*

@Composable
fun MainWeather() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text (
            text = "Search City....",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            fontFamily = GoogleSansBold,
            color = White
        )

        SearchBox()
        WeatherCard()
        DataBox()
    }
}

@Composable
fun WeatherCard() {
    Row {
        CardUI(
            temperature = "30oC",
            city = "Tomsk",
            humidity = "77%",
            wind = "3 km/h"
        )
        /*CardUI(
            temperature = "35oC",
            city = "Novisbirsk",
            humidity = "67%",
            wind = "4 km/h"
        )*/
    }
}

@Composable
fun CardUI(
    temperature: String,
    city: String,
    humidity: String,
    wind: String
) {
    Card(backgroundColor = BackgroundColor, elevation = 0.dp) {
        Box(modifier = Modifier
            .width(150.dp)
            .padding(10.dp),
            contentAlignment = Alignment.TopEnd
        ) {
        }

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = city, fontFamily = GoogleSansMedium, fontSize = 14.sp, color = White)
            Spacer(modifier = Modifier.height(0.dp))
            Text(
                text = getTemperature(temperature = temperature).toAnnotatedString(),
                fontFamily = GoogleSansRegular,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(0.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = humidity,
                    fontFamily = GoogleSansBold,
                    fontSize = 12.sp,
                    color = White
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = wind,
                    fontFamily = GoogleSansRegular,
                    fontSize = 12.sp,
                    color = White
                )
            }
        }
    }
}

fun getTemperature(temperature: String): AnnotatedString.Builder {
    val annotatedString = AnnotatedString.Builder(temperature)
        .apply {
            addStyle(
                SpanStyle(
                    fontSize = 18.sp,
                    baselineShift = BaselineShift.Superscript
                ), 2, 3
            )
        }
    return annotatedString
}

@Composable
fun SearchBox() {
    var text by remember { mutableStateOf("" ) }

    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = null,
        placeholder = { Text("Search") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = BackgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp, bottom = 8.dp)
            .clip(SearchShape.medium),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = White,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}

@Composable
fun DataBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Card(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Precipation",
                        fontFamily = GoogleSansRegular,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "35 %",
                        fontFamily = GoogleSansRegular,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "Humidity",
                        fontFamily = GoogleSansRegular,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "30%",
                        fontFamily = GoogleSansRegular,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .height(80.dp)
                        .background(BackgroundColor)
                )
                Column {
                    Text(
                        text = "Wind",
                        fontFamily = GoogleSansRegular,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "160",
                        fontFamily = GoogleSansRegular,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "Pressure",
                        fontFamily = GoogleSansRegular,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                    Text(
                        text = "450hPa",
                        fontFamily = GoogleSansRegular,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Medium,
                        color = White
                    )
                }
            }
        }
    }
}