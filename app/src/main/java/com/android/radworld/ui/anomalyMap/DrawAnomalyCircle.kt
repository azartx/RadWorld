package com.android.radworld.ui.anomalyMap

import android.graphics.Color
import com.google.android.libraries.maps.model.CircleOptions
import com.google.android.libraries.maps.model.LatLng


/**
 * отрисовывает круг по принятив координатом в формате LatLng
 *
 * возвращает CircleOptions
 *
 * далее -> googleMap.addCircle(полученный результат из функции)
 */

class DrawAnomalyCircle {
    fun drawAnomaly(latLon: LatLng) = CircleOptions().apply {
        center(latLon)
        radius(20.0)
        strokeColor(Color.RED)
        fillColor(Color.YELLOW)
        strokeWidth(2F)
    }
}