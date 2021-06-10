package com.gb.weatherproject.database

import android.app.Application

class WeatherIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        WeatherRepository.initialize(this)
    }
}