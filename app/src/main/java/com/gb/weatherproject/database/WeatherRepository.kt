package com.gb.weatherproject.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

private const val DATABASE_NAME = "weather-database"

class WeatherRepository private constructor(context: Context) {

    private val database: WeatherDatabase = Room.databaseBuilder(
        context.applicationContext,
        WeatherDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val weatherDao = database.weatherHistoryDao

    fun getHistory(city: String): LiveData<List<WeatherHistory>> = weatherDao.getHistory(city)
    suspend fun insert(weatherHistory: WeatherHistory) = weatherDao.insert(weatherHistory)
    suspend fun clear(city: String) = weatherDao.clear(city)

    companion object {
        private var INSTANCE: WeatherRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = WeatherRepository(context)
            }
        }

        fun get(): WeatherRepository {
            return INSTANCE ?: throw IllegalStateException("WeatherRepository must be initialized")
        }
    }
}