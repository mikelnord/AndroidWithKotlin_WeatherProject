package com.gb.weatherproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WeatherHistoryDao {
    @Insert
    suspend fun insert(weatherHistory: WeatherHistory)

    @Update
    suspend fun update(weatherHistory: WeatherHistory)

    @Query("SELECT * FROM weather_history_table WHERE city = :city ORDER BY id DESC")
    fun getHistory(city: String): LiveData<List<WeatherHistory>>

    @Query("DELETE FROM weather_history_table WHERE city = :city")
    suspend fun clear(city: String)

}