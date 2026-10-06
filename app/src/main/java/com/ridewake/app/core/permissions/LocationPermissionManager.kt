package com.ridewake.app.core.permissions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * Centralized location permission handling for RideWake AI.
 *
 * This manager only checks whether the application currently
 * has the required location permissions.
 *
 * Permission requests are handled by the presentation layer.
 */
object LocationPermissionManager {

    /**
     * Permissions requested by RideWake AI for location access.
     *
     * ACCESS_COARSE_LOCATION allows approximate location.
     * ACCESS_FINE_LOCATION allows precise location, required
     * for reliable trip monitoring.
     */
    val permissions = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )

    /**
     * Returns true when precise location permission
     * has been granted to the application.
     */
    fun hasPreciseLocationPermission(
        context: Context
    ): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Returns true when the application has at least
     * approximate location access.
     */
    fun hasAnyLocationPermission(
        context: Context
    ): Boolean {
        val coarseLocationGranted =
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

        val fineLocationGranted =
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

        return coarseLocationGranted || fineLocationGranted
    }
}