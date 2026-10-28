package com.ridewake.app.core.trip.engine

import com.ridewake.app.core.trip.model.TripState
import com.ridewake.app.presentation.components.PredictiveAlertLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.max

class TripSimulationEngine {
    private val _tripState = MutableStateFlow(TripState())
    val tripState: StateFlow<TripState> = _tripState.asStateFlow()

    private var simulationJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    fun startTrip(destination: String) {
        stopTrip()
        _tripState.value = TripState(
            destination = destination,
            remainingDistanceKm = 3.2,
            remainingMinutes = 12,
            totalDistanceKm = 3.2,
            alertLevel = PredictiveAlertLevel.EARLY,
            isArrived = false
        )

        simulationJob = scope.launch {
            var currentDist = 3.2
            while (currentDist > 0.0) {
                delay(1800) // update every 1.8 seconds for smooth watch demo
                currentDist = max(0.0, currentDist - 0.2)

                val currentMinutes = max(0, ((currentDist / 3.2) * 12).toInt())
                val alertLevel = when {
                    currentDist > 1.5 -> PredictiveAlertLevel.EARLY
                    currentDist > 0.5 -> PredictiveAlertLevel.NEAR
                    else -> PredictiveAlertLevel.IMMEDIATE
                }
                val arrived = currentDist <= 0.0

                _tripState.update {
                    it.copy(
                        remainingDistanceKm = currentDist,
                        remainingMinutes = currentMinutes,
                        alertLevel = alertLevel,
                        isArrived = arrived
                    )
                }

                if (arrived) break
            }
        }
    }

    fun stopTrip() {
        simulationJob?.cancel()
        simulationJob = null
        _tripState.value = TripState()
    }
}
