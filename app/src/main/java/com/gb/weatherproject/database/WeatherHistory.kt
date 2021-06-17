package com.gb.weatherproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "weather_history_table")
data class WeatherHistory(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    val city: String,
    val temperature: String,
    val date: String,
    val condition: String
)
