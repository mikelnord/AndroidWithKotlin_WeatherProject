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

class WeatherDetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var weatherDetailViewModel: WeatherDetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = WeatherDetailFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = WeatherDetailViewModelFactory(arguments.id, dataset = Dataset)
        weatherDetailViewModel = ViewModelProvider(this, viewModelFactory).get(
            WeatherDetailViewModel::class.java
        )
        binding.lifecycleOwner = this
        binding.viewModel = weatherDetailViewModel
        binding.buttonClear.setOnClickListener {
            weatherDetailViewModel.clear()
        }

        val adapter = WeatherHistoryAdapter()

        binding.lifecycleOwner?.let {
            weatherDetailViewModel.history.observe(
                it,
                {
                    adapter.data = it
                    binding.listHistory.adapter = adapter
                }
            )
        }

    }

    override fun onStop() {
        weatherDetailViewModel.insertHistory()
        super.onStop()
    }

}