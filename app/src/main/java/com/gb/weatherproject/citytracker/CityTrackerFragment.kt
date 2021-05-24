package com.gb.weatherproject.citytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gb.weatherproject.R
import com.gb.weatherproject.databinding.FragmentCityTrackerBinding
import com.gb.weatherproject.model.RepositoryImpl

class CityTrackerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentCityTrackerBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_city_tracker, container, false
        )
        val repository = RepositoryImpl()
        val viewModelFactory = CityTrackerViewModelFactory(repository)
        val cityTrackerViewModel =
            ViewModelProvider(this, viewModelFactory).get(CityTrackerViewModel::class.java)
        binding.lifecycleOwner = this
        val adapter = WeatherAdapter(WeatherListener { id ->
            cityTrackerViewModel.onWeatherClicked(id)
        })
        cityTrackerViewModel.navigateToWeatherDetail.observe(viewLifecycleOwner, { id ->
            id?.let {
                this.findNavController().navigate(
                    CityTrackerFragmentDirections.actionCityTrackerFragmentToWeatherDetailFragment(
                        id
                    )
                )
                cityTrackerViewModel.onWeatherNavigated()
            }
        })
        adapter.data = cityTrackerViewModel.citys
        binding.cityList.adapter = adapter
        return binding.root
    }
}