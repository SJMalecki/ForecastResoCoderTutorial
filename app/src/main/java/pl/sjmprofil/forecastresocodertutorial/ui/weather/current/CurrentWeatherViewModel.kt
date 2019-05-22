package pl.sjmprofil.forecastresocodertutorial.ui.weather.current

import androidx.lifecycle.ViewModel
import pl.sjmprofil.forecastresocodertutorial.data.repository.ForecastRepository
import pl.sjmprofil.forecastresocodertutorial.internal.Unitsystem
import pl.sjmprofil.forecastresocodertutorial.internal.lazyDeffered

class CurrentWeatherViewModel(private val forecastRepository: ForecastRepository) : ViewModel() {

    private val unitSystem = Unitsystem.METRIC // get from settings later

    val isMetric: Boolean
        get() = unitSystem == Unitsystem.METRIC

    val weather by lazyDeffered {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
