package com.gb.weatherproject.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gb.weatherproject.model.Repository


class WeatherDetailViewModelFactory (private val id: Int,private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherDetailViewModel::class.java)) {
            return WeatherDetailViewModel(id,repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
