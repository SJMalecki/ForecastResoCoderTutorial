package pl.sjmprofil.forecastresocodertutorial.data.db.unitlocalized

interface UnitSepcificCurrentWeatherEntry {

    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double

}