package com.gb.weatherproject.citytracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gb.weatherproject.model.Repository

class CityTrackerViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityTrackerViewModel::class.java)) {
            return CityTrackerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
