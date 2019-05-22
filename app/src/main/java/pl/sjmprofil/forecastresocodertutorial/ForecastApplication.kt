package pl.sjmprofil.forecastresocodertutorial

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import pl.sjmprofil.forecastresocodertutorial.data.ApixuWeatherApiService
import pl.sjmprofil.forecastresocodertutorial.data.db.ForecastDatabase
import pl.sjmprofil.forecastresocodertutorial.data.network.ConnectivityInterceptor
import pl.sjmprofil.forecastresocodertutorial.data.network.ConnectivityInterceptorImpl
import pl.sjmprofil.forecastresocodertutorial.data.network.WeatherNetworkDataSource
import pl.sjmprofil.forecastresocodertutorial.data.network.WeatherNetworkDataSourceImpl
import pl.sjmprofil.forecastresocodertutorial.data.repository.ForecastRepository
import pl.sjmprofil.forecastresocodertutorial.data.repository.ForecastRepositoryImpl
import pl.sjmprofil.forecastresocodertutorial.ui.weather.current.CurrentWeatherViewModelFactory

class ForecastApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance())}
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}
