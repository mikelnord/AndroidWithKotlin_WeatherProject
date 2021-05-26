package com.gb.weatherproject.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gb.weatherproject.database.Dataset


class WeatherDetailViewModelFactory(private val id: Int, private val dataset: Dataset) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherDetailViewModel::class.java)) {
            return WeatherDetailViewModel(id, dataset) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
