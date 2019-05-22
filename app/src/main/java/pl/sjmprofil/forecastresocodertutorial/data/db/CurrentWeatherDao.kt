package pl.sjmprofil.forecastresocodertutorial.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.sjmprofil.forecastresocodertutorial.data.db.entity.CURRENT_WEATHER_ID
import pl.sjmprofil.forecastresocodertutorial.data.db.entity.CurrentWeatherEntry
import pl.sjmprofil.forecastresocodertutorial.data.db.unitlocalized.ImperialCurrentWeatherEntry
import pl.sjmprofil.forecastresocodertutorial.data.db.unitlocalized.MetricCurrentWeatherEntry
import pl.sjmprofil.forecastresocodertutorial.data.db.unitlocalized.UnitSepcificCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)


    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}