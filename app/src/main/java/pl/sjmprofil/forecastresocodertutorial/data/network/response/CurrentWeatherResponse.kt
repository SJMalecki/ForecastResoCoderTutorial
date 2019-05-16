package pl.sjmprofil.forecastresocodertutorial.data.network.response

import com.google.gson.annotations.SerializedName
import pl.sjmprofil.forecastresocodertutorial.data.db.entity.CurrentWeatherEntry
import pl.sjmprofil.forecastresocodertutorial.data.db.entity.Location


data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)