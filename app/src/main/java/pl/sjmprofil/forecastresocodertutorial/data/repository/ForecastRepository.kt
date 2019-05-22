package pl.sjmprofil.forecastresocodertutorial.data.repository

import androidx.lifecycle.LiveData
import pl.sjmprofil.forecastresocodertutorial.data.db.unitlocalized.UnitSepcificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSepcificCurrentWeatherEntry>
}