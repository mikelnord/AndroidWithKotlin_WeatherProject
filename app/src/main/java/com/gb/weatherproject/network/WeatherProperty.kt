package com.gb.weatherproject.network


data class WeatherProperty(
    val location: City,
    val current: Weather
)

data class City(
    val name: String,
    val region: String,
    val country: String,
    val lat: String,
    val lon: String,
    val tz_id: String,
    val localtime: String
)

data class Weather(
    val last_updated: String,
    val temp_c: String,
    val is_day: Int,
    val condition: Condition,
    val feelslike_c: String
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)