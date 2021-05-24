package com.gb.weatherproject.ui.main

import androidx.lifecycle.ViewModel
import android.os.SystemClock.sleep
import androidx.lifecycle.MutableLiveData
import com.gb.weatherproject.AppState
import com.gb.weatherproject.model.Repository
import com.gb.weatherproject.model.RepositoryImpl

class MainViewModel(private val liveDataToObserve: MutableLiveData<Any> = MutableLiveData(),
                    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getWeatherFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getWeatherFromLocalStorage()))
        }.start()
    }


}