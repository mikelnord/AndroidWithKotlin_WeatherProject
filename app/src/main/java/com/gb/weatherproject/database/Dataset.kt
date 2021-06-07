package com.gb.weatherproject.database

import com.gb.weatherproject.model.City
import com.gb.weatherproject.model.Weather

object Dataset {
    val listWeather: List<Weather> = listOf(
        Weather(0, City("Москва", 55.755826, 37.617299900000035), 1, 2),
        Weather(1, City("Санкт-Петербург", 59.9342802, 30.335098600000038), 3, 3),
        Weather(2, City("Новосибирск", 55.00835259999999, 82.93573270000002), 5, 6),
        Weather(3, City("Екатеринбург", 56.83892609999999, 60.60570250000001), 7, 8),
        Weather(4, City("Нижний Новгород", 56.2965039, 43.936059), 9, 10),
        Weather(5, City("Казань", 55.8304307, 49.06608060000008), 11, 12),
        Weather(6, City("Челябинск", 55.1644419, 61.4368432), 13, 14),
        Weather(7, City("Омск", 54.9884804, 73.32423610000001), 15, 16),
        Weather(8, City("Ростов-на-Дону", 47.2357137, 39.701505), 17, 18),
        Weather(9, City("Уфа", 54.7387621, 55.972055400000045), 19, 20),
        Weather(10, City("Владивосток", 0.0, 0.0), 19, 20),
        Weather(11, City("Хабаровск", 0.0, 0.0), 19, 20),
        Weather(12, City("Севастополь", 0.0, 0.0), 19, 20)
    )

    fun getCitysRu(): List<Weather> {
        return listWeather
    }

    fun getWeatherFromId(id: Int): Weather {
        return listWeather[id]
    }
}