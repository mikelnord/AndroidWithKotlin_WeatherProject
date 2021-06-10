package com.gb.weatherproject.model

data class City(
    val city: String,
    val lat: Double,
    val lon: Double
)
data class Weather(
    val id:Int,
    val city: City,
    val temperature: Int = 0,
    val feelsLike: Int = 0
)


