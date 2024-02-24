package com.orimous.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.orimous.weather.screens.HomeScreen
import com.orimous.weather.viewModel.WeatherViewModel

const val API_KEY = "3b33ada2025041ed9d9112344242202"

class MainActivity(viewModel: WeatherViewModel) : ComponentActivity() {

    private val stateTempC = viewModel.stateTempC
    private val stateCity = viewModel.stateCity
    private val stateDate = viewModel.stateDate
    private val stateMaxTemp = viewModel.stateMaxTemp
    private val stateMinTemp = viewModel.stateMinTemp
    private val stateFeelsLikeC = viewModel.stateFeelsLikeC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 0.dp),
                color = Color.White
            ) {
                HomeScreen(
                    date = stateDate.value,
                    onClick = { WeatherViewModel().getResult(this) },
                    city = stateCity.value,
                    tempC = stateTempC.value,
                    maxTempC = stateMaxTemp.value,
                    minTempC = stateMinTemp.value,
                    feelsLikeC =stateFeelsLikeC.value
                )
            }
        }
    }
}
