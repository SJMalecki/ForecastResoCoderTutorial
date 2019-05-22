package pl.sjmprofil.forecastresocodertutorial.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.sjmprofil.forecastresocodertutorial.data.ApixuWeatherApiService
import pl.sjmprofil.forecastresocodertutorial.data.network.response.CurrentWeatherResponse
import pl.sjmprofil.forecastresocodertutorial.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(private val apixuWeatherApiService: ApixuWeatherApiService) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
       try {
           val fetchCurrentWeather = apixuWeatherApiService
               .getCurrentWeather(location, languageCode)
               .await()
           _downloadedCurrentWeather.postValue(fetchCurrentWeather)
       }catch (e: NoConnectivityException){
           Log.e("Connectivity", "No internet connection.", e)
       }
    }
}