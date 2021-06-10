package com.gb.weatherproject.citytracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.weatherproject.databinding.TextItemViewBinding
import com.gb.weatherproject.model.Weather

class WeatherAdapter(private val clickListener: WeatherListener) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    var data = listOf<Weather>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount() = data.size


    class ViewHolder private constructor(private val binding: TextItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(weather: Weather, clickListener: WeatherListener) {
            binding.weather = weather
            binding.clickListener = clickListener

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TextItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class WeatherListener(val clickListener: (id: Int) -> Unit) {
    fun onClick(weather: Weather) = clickListener(weather.id)
}