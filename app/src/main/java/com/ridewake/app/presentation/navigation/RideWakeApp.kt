package com.ridewake.app.presentation.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.ridewake.app.core.localization.LanguageManager
import com.ridewake.app.presentation.screens.confirmation.ConfirmationScreen
import com.ridewake.app.presentation.screens.destination.DestinationScreen
import com.ridewake.app.presentation.screens.home.HomeScreen
import com.ridewake.app.presentation.screens.settings.SettingsScreen
import com.ridewake.app.presentation.screens.trip.TripScreen

private const val HOME_SCREEN = "home"
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

    when (currentScreen) {

        HOME_SCREEN -> {
            HomeScreen(
                onStartTrip = {
                    currentScreen = DESTINATION_SCREEN
                },
                onOpenSettings = {
                    currentScreen = SETTINGS_SCREEN
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
                // Evita finalizar accidentalmente el viaje.
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