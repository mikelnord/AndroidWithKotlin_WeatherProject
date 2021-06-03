package com.gb.weatherproject.model

class RepositoryImpl : Repository {

   private lateinit var listWeather: List<Weather>

    override fun getWeatherFromServer(): Weather {
        return Weather(0)
    }

    override fun getWeatherFromLocalStorage(): Weather {
        return Weather(0)
    }
}
