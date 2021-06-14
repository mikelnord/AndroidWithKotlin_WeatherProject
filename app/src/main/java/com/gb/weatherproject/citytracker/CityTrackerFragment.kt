package com.gb.weatherproject.citytracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.gb.weatherproject.R
import com.gb.weatherproject.database.Dataset
import com.gb.weatherproject.databinding.FragmentCityTrackerBinding
import com.gb.weatherproject.network.ConnectionLiveData

class CityTrackerFragment : Fragment() {
    private var binding: FragmentCityTrackerBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_city_tracker, container, false
        )
        setHasOptionsMenu(true)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = CityTrackerViewModelFactory(dataset = Dataset)
        val cityTrackerViewModel =
            ViewModelProvider(this, viewModelFactory).get(CityTrackerViewModel::class.java)
        binding?.lifecycleOwner = this
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
        binding?.cityList?.adapter = adapter

        val connectionLiveData = context?.let { ConnectionLiveData(it) }
        connectionLiveData?.observe(viewLifecycleOwner, {
            if (it)
                binding?.textNetStatus?.text = "Connection active"
            else
                binding?.textNetStatus?.text = "Connection lost"
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}