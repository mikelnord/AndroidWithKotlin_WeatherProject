package com.gb.weatherproject.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherHistory::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract val weatherHistoryDao: WeatherHistoryDao

}