package com.orimous.weather.viewModel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.orimous.weather.API_KEY
import org.json.JSONObject

class WeatherViewModel(
): ViewModel(){
    val stateTempC = mutableStateOf("")
    val stateCity = mutableStateOf("Казань")
    val stateDate = mutableStateOf("")
    val stateMaxTemp = mutableStateOf("")
    val stateMinTemp = mutableStateOf("")
    val stateFeelsLikeC = mutableStateOf("")

    fun getResult(
        context: Context
    ) {
        val url = "https://api.worldweatheronline.com/premium/v1/weather.ashx" +
                "?key=$API_KEY&q=${stateCity.value}&format=json"
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(url,
            { result ->
                val obj = JSONObject(result)
                val mainObj = obj.getJSONObject("data")

                val currentCondition = mainObj.getJSONArray("current_condition")
                val request = mainObj.getJSONArray("request")
                val weatherInfo = mainObj.getJSONArray("weather")
                val hourly = weatherInfo.getJSONArray(11)

                val feelsLikeObj = hourly[27] as JSONObject
                val feelsLikeC = feelsLikeObj.getString("FeelsLikeC")
                val weatherDateObj = weatherInfo[0] as JSONObject
                val date = weatherDateObj.getString("date")
                val weatherMaxTempObj = weatherInfo[2] as JSONObject
                val maxTemp = weatherMaxTempObj.getString("maxtempC")
                val weatherMinTempObj = weatherInfo[4] as JSONObject
                val minTemp = weatherMinTempObj.getString("mintempC")
                val temPCObj = currentCondition[0] as JSONObject
                val tempC = temPCObj.getString("temp_C")
                val cityObj = request[0] as JSONObject
                val getCity = cityObj.getString("query")

                stateCity.value = getCity
                stateTempC.value = tempC
                stateDate.value = date
                stateMaxTemp.value = maxTemp
                stateMinTemp.value = minTemp
                stateFeelsLikeC.value = feelsLikeC
            }, {
                Log.d("MyLog", "Error: $it")
            }
        )
        queue.add(request)
    }

}