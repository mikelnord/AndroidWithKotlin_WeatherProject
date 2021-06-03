package com.gb.weatherproject.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.weatherproject.database.Dataset
import com.gb.weatherproject.model.Weather
import com.gb.weatherproject.network.WeatherApi
import com.gb.weatherproject.network.WeatherProperty
import kotlinx.coroutines.launch

class WeatherDetailViewModel(id: Int, dataset: Dataset) : ViewModel() {

    private val weather: Weather

    fun getWeather(): Weather {
        return weather
    }

    private val _response = MutableLiveData<WeatherProperty>()
    val response: LiveData<WeatherProperty>
        get() = _response

    init {
        weather = dataset.getWeatherFromId(id)
        getWeatherProperties()
    }

    private fun getWeatherProperties() {
        viewModelScope.launch {
            try {

                _response.value = WeatherApi.retrofitService.requestWeatherForCity(
                    "db0aebcfc78145daa67100341212905",
                    weather.city.city,
                    "ru"
                )

            } catch (e: Exception) {

                Log.e("Weather", e.message.toString())

            }
        }
    }

}