package com.gb.weatherproject.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.weatherproject.database.WeatherHistory
import com.gb.weatherproject.databinding.WeatherHistoryViewBinding

class WeatherHistoryAdapter() :
    RecyclerView.Adapter<WeatherHistoryAdapter.ViewHolder>() {

    var data = listOf<WeatherHistory>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


    class ViewHolder private constructor(private val binding: WeatherHistoryViewBinding) :
        RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun bind(weather: WeatherHistory) {
            binding.weatherHistory = weather
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WeatherHistoryViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}