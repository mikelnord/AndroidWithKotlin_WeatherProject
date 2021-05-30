package com.gb.weatherproject.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gb.weatherproject.R
import com.gb.weatherproject.database.Dataset
import com.gb.weatherproject.databinding.FragmentDetailBinding
import com.gb.weatherproject.model.RepositoryImpl

class WeatherDetailFragment : Fragment() {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container, false
        )

        val arguments = WeatherDetailFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = WeatherDetailViewModelFactory(arguments.id, dataset = Dataset)
        val weatherDetailViewModel = ViewModelProvider(this, viewModelFactory).get(
            WeatherDetailViewModel::class.java
        )
        binding.setLifecycleOwner(this)
        binding.viewModel = weatherDetailViewModel
        return binding.root
    }
}