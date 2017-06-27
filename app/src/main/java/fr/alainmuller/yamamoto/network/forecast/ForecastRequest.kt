package fr.alainmuller.yamamoto.network.forecast

import android.util.Log
import java.net.URL

class ForecastRequest(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, "requested forecase : '$forecastJsonStr'")
    }
}