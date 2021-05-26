package com.gb.weatherproject.detail

import androidx.lifecycle.ViewModel
import com.gb.weatherproject.database.Dataset
import com.gb.weatherproject.model.Weather

class WeatherDetailViewModel(id: Int, dataset:Dataset):ViewModel() {

    private val weather: Weather = dataset.getWeatherFromId(id)

    fun getWeather(): Weather {
        return weather
    }

}