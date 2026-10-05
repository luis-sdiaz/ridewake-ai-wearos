package com.ridewake.app.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.ridewake.app.presentation.screens.confirmation.ConfirmationScreen
import com.ridewake.app.presentation.screens.destination.DestinationScreen
import com.ridewake.app.presentation.screens.home.HomeScreen

private const val HOME_SCREEN = "home"
private const val DESTINATION_SCREEN = "destination"
private const val CONFIRMATION_SCREEN = "confirmation"

@Composable
fun RideWakeApp() {
    var currentScreen by rememberSaveable {
        mutableStateOf(HOME_SCREEN)
    }

    var selectedDestination by rememberSaveable {
        mutableStateOf<String?>(null)
    }

    when (currentScreen) {
        HOME_SCREEN -> {
            HomeScreen(
                onStartTrip = {
                    currentScreen = DESTINATION_SCREEN
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
                    // Aquí conectaremos la pantalla de viaje activo.
                },
                onChangeDestination = {
                    currentScreen = DESTINATION_SCREEN
                }
            )
        }
    }
}