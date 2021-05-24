package com.gb.weatherproject.citytracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.weatherproject.model.Repository

class CityTrackerViewModel(repository: Repository) : ViewModel() {

    private val _navigateToWeatherDetail = MutableLiveData<Int?>()
    val navigateToWeatherDetail
        get() = _navigateToWeatherDetail

    val citys = repository.getCitysRu()

    fun onWeatherNavigated() {
        _navigateToWeatherDetail.value = null
    }

    fun onWeatherClicked(id: Int) {
        _navigateToWeatherDetail.value = id
    }
}