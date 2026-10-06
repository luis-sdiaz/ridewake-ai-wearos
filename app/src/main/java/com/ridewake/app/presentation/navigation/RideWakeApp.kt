package com.ridewake.app.presentation.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.ridewake.app.core.localization.LanguageManager
import com.ridewake.app.core.permissions.LocationPermissionManager
import com.ridewake.app.presentation.screens.confirmation.ConfirmationScreen
import com.ridewake.app.presentation.screens.destination.DestinationScreen
import com.ridewake.app.presentation.screens.home.HomeScreen
import com.ridewake.app.presentation.screens.location.LocationPermissionScreen
import com.ridewake.app.presentation.screens.settings.SettingsScreen
import com.ridewake.app.presentation.screens.trip.TripScreen

private const val HOME_SCREEN = "home"
private const val LOCATION_PERMISSION_SCREEN = "location_permission"
private const val DESTINATION_SCREEN = "destination"
private const val CONFIRMATION_SCREEN = "confirmation"
private const val TRIP_SCREEN = "trip"
private const val SETTINGS_SCREEN = "settings"

@Composable
fun RideWakeApp() {
    val context = LocalContext.current

    var currentScreen by rememberSaveable {
        mutableStateOf(HOME_SCREEN)
    }

    var selectedDestination by rememberSaveable {
        mutableStateOf<String?>(null)
    }

    val currentLanguage = LanguageManager.getLanguage(context)

    val locationPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (
                LocationPermissionManager
                    .hasPreciseLocationPermission(context)
            ) {
                currentScreen = DESTINATION_SCREEN
            }
        }

    when (currentScreen) {

        HOME_SCREEN -> {
            HomeScreen(
                onStartTrip = {
                    if (
                        LocationPermissionManager
                            .hasPreciseLocationPermission(context)
                    ) {
                        currentScreen = DESTINATION_SCREEN
                    } else {
                        currentScreen = LOCATION_PERMISSION_SCREEN
                    }
                },
                onOpenSettings = {
                    currentScreen = SETTINGS_SCREEN
                }
            )
        }

        LOCATION_PERMISSION_SCREEN -> {
            BackHandler {
                currentScreen = HOME_SCREEN
            }

            LocationPermissionScreen(
                onRequestPermission = {
                    locationPermissionLauncher.launch(
                        LocationPermissionManager.permissions
                    )
                },
                onNotNow = {
                    currentScreen = HOME_SCREEN
                }
            )
        }

        DESTINATION_SCREEN -> {
            BackHandler {
                currentScreen = HOME_SCREEN
            }

            DestinationScreen(
                onContinue = { destination ->
                    selectedDestination = destination
                    currentScreen = CONFIRMATION_SCREEN
                }
            )
        }

        CONFIRMATION_SCREEN -> {
            BackHandler {
                currentScreen = DESTINATION_SCREEN
            }

            ConfirmationScreen(
                destination = selectedDestination.orEmpty(),
                onStartTrip = {
                    currentScreen = TRIP_SCREEN
                },
                onChangeDestination = {
                    currentScreen = DESTINATION_SCREEN
                }
            )
        }

        TRIP_SCREEN -> {
            BackHandler {
                // Prevent accidental trip termination.
            }

            TripScreen(
                destination = selectedDestination.orEmpty(),
                onEndTrip = {
                    selectedDestination = null
                    currentScreen = HOME_SCREEN
                }
            )
        }

        SETTINGS_SCREEN -> {
            BackHandler {
                currentScreen = HOME_SCREEN
            }

            SettingsScreen(
                currentLanguage = currentLanguage,
                onLanguageSelected = { languageCode ->
                    if (languageCode != currentLanguage) {
                        LanguageManager.setLanguage(
                            context = context,
                            languageCode = languageCode
                        )

                        (context as? Activity)?.recreate()
                    }
                },
                onBack = {
                    currentScreen = HOME_SCREEN
                }
            )
        }
    }
}