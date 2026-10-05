package com.ridewake.app.presentation.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.ColorScheme
import androidx.wear.compose.material3.MaterialTheme

/**
 * RideWake AI Material 3 color scheme.
 *
 * Maps the RideWake AI semantic design tokens to
 * the official Wear OS Material 3 color roles.
 */
private val RideWakeColorScheme = ColorScheme(

    // Primary brand
    primary = RideWakeColors.Primary,
    primaryDim = RideWakeColors.Primary,
    primaryContainer = RideWakeColors.SurfaceSelected,
    onPrimary = RideWakeColors.OnPrimary,
    onPrimaryContainer = RideWakeColors.TextPrimary,

    // Secondary / positive status
    secondary = RideWakeColors.Success,
    secondaryDim = RideWakeColors.Success,
    secondaryContainer = RideWakeColors.SurfaceStatus,
    onSecondary = RideWakeColors.OnPrimary,
    onSecondaryContainer = RideWakeColors.TextPrimary,

    // Tertiary / attention
    tertiary = RideWakeColors.Warning,
    tertiaryDim = RideWakeColors.Warning,
    tertiaryContainer = RideWakeColors.AlertNearSurface,
    onTertiary = RideWakeColors.OnPrimary,
    onTertiaryContainer = RideWakeColors.TextPrimary,

    // Surfaces
    surfaceContainerLow = RideWakeColors.SurfaceOption,
    surfaceContainer = RideWakeColors.Surface,
    surfaceContainerHigh = RideWakeColors.SurfaceVariant,
    onSurface = RideWakeColors.TextPrimary,
    onSurfaceVariant = RideWakeColors.TextSecondary,

    // Structure
    outline = RideWakeColors.Border,
    outlineVariant = RideWakeColors.BorderOption,

    // Background
    background = RideWakeColors.Background,
    onBackground = RideWakeColors.TextPrimary,

    // Error / critical states
    error = RideWakeColors.Critical,
    errorDim = RideWakeColors.Critical,
    errorContainer = RideWakeColors.AlertImmediateSurface,
    onError = RideWakeColors.OnPrimary,
    onErrorContainer = RideWakeColors.TextPrimary
)

/**
 * Global RideWake AI theme.
 *
 * All Wear Material 3 components inside this hierarchy
 * inherit the RideWake AI visual identity.
 */
@Composable
fun RideWakeAITheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = RideWakeColorScheme,
        content = content
    )
}