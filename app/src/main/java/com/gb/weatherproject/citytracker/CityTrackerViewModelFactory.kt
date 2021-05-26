package com.gb.weatherproject.citytracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gb.weatherproject.database.Dataset

class CityTrackerViewModelFactory(private val dataset:Dataset) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityTrackerViewModel::class.java)) {
            return CityTrackerViewModel(dataset) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
