package com.gb.weatherproject.detail

import androidx.lifecycle.ViewModel
import com.gb.weatherproject.model.Repository
import com.gb.weatherproject.model.Weather

class WeatherDetailViewModel(id: Int, repository: Repository):ViewModel() {

    private val weather: Weather = repository.getWeatherFromId(id)

    fun getweather(): Weather {
        return weather
    }

}