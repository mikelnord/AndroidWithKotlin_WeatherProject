package com.gb.weatherproject.model

import androidx.lifecycle.LiveData

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
    fun getCitysRu(): List<Weather>
    fun getWeatherFromId(id:Int): Weather
}