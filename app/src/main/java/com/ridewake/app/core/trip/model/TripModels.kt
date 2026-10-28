package com.ridewake.app.core.trip.model

import com.ridewake.app.presentation.components.PredictiveAlertLevel

data class TripState(
    val destination: String = "",
    val remainingDistanceKm: Double = 3.2,
    val remainingMinutes: Int = 12,
    val totalDistanceKm: Double = 3.2,
    val alertLevel: PredictiveAlertLevel = PredictiveAlertLevel.EARLY,
    val isArrived: Boolean = false
) {
    val progressFraction: Float
        get() = if (totalDistanceKm > 0.0) {
            ((totalDistanceKm - remainingDistanceKm) / totalDistanceKm).coerceIn(0.0, 1.0).toFloat()
        } else {
            0f
        }
}
