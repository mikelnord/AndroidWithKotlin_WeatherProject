package com.gb.weatherproject.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.weatherproject.database.Dataset
import com.gb.weatherproject.database.WeatherHistory
import com.gb.weatherproject.database.WeatherRepository
import com.gb.weatherproject.model.Weather
import com.gb.weatherproject.network.WeatherApi
import com.gb.weatherproject.network.WeatherProperty
import kotlinx.coroutines.launch

class WeatherDetailViewModel(id: Int, dataset: Dataset) : ViewModel() {

    private val weather: Weather


    private val weatherRepository = WeatherRepository.get()


    val history: LiveData<List<WeatherHistory>>

    private val _response = MutableLiveData<WeatherProperty>()
    val response: LiveData<WeatherProperty>
        get() = _response

    init {
        weather = dataset.getWeatherFromId(id)
        getWeatherProperties()
        history = weatherRepository.getHistory(weather.city.city)
    }

    private fun getWeatherProperties() {
        viewModelScope.launch {
            try {

                _response.value = WeatherApi.retrofitService.requestWeatherForCity(
                    "db0aebcfc78145daa67100341212905",
                    weather.city.city,
                    "ru"
                )
                response.value?.let {
                    weatherRepository.insert(
                        WeatherHistory(
                            0,
                            response.value!!.location.name,
                            response.value!!.current.temp_c,
                            response.value!!.current.last_updated,
                            response.value!!.current.condition.text
                        )
                    )
                }


            } catch (e: Exception) {

                Log.e("Weather", e.message.toString())

            }
        }
    }

    fun clear() {
        viewModelScope.launch {
            weatherRepository.clear(weather.city.city)
        }
    }

}