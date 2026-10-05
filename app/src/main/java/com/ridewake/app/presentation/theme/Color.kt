package com.ridewake.app.presentation.theme

import androidx.compose.ui.graphics.Color

/**
 * RideWake AI Design System
 *
 * Global color tokens.
 * These values define the core visual identity of the application.
 */
object RideWakePalette {

    // Brand
    val Cyan500 = Color(0xFF59D9FF)

    // Feedback
    val Mint400 = Color(0xFF72E4C1)
    val Amber400 = Color(0xFFFFC857)
    val Coral400 = Color(0xFFFF6B6B)

    // Backgrounds
    val Navy950 = Color(0xFF020405)
    val Navy900 = Color(0xFF071015)
    val Navy875 = Color(0xFF09171D)
    val Navy840 = Color(0xFF0D252F)
    val Navy825 = Color(0xFF0D2028)
    val Navy820 = Color(0xFF101D22)
    val Navy800 = Color(0xFF0C2028)
    val Navy775 = Color(0xFF10262D)
    val Navy750 = Color(0xFF102A33)
    val Navy725 = Color(0xFF112832)
    val Navy700 = Color(0xFF123442)
    val Navy675 = Color(0xFF113847)

    // Alert surfaces
    val Amber950 = Color(0xFF2A2516)
    val Coral950 = Color(0xFF2C191C)

    // Borders
    val Slate750 = Color(0xFF193642)
    val Slate720 = Color(0xFF1B333D)
    val Slate700 = Color(0xFF193A46)

    // Text
    val White = Color(0xFFFFFFFF)
    val Slate300 = Color(0xFFB6C4CA)
    val Slate325 = Color(0xFFA9BBC2)
    val Slate350 = Color(0xFF9DB3BD)
    val Slate400 = Color(0xFF96A9B3)
    val Slate425 = Color(0xFF8FA3AC)
    val Slate500 = Color(0xFF82959E)

    // Disabled
    val DisabledSurface = Color(0xFF16262D)
    val DisabledContent = Color(0xFF60737C)

    // High contrast
    val Ink = Color(0xFF001018)
}

/**
 * Semantic color tokens.
 *
 * Screens and components should prefer these names instead of
 * accessing raw palette values directly.
 */
object RideWakeColors {

    // Brand
    val Primary = RideWakePalette.Cyan500
    val OnPrimary = RideWakePalette.Ink

    // Main backgrounds
    val Background = RideWakePalette.Navy950
    val BackgroundMiddle = RideWakePalette.Navy900
    val BackgroundGlow = RideWakePalette.Navy700

    // General surfaces
    val Surface = RideWakePalette.Navy800
    val SurfaceVariant = RideWakePalette.Navy750

    // Component surfaces
    val SurfaceOption = RideWakePalette.Navy875
    val SurfaceIndicator = RideWakePalette.Navy825
    val SurfaceStatus = RideWakePalette.Navy775
    val SurfaceIcon = RideWakePalette.Navy725
    val SurfaceSelected = RideWakePalette.Navy675

    // Trip surfaces
    val TripStatusSurface = RideWakePalette.Navy750
    val TripActionSurface = RideWakePalette.Navy820

    // Predictive alert surfaces
    val AlertEarlySurface = RideWakePalette.Navy840
    val AlertNearSurface = RideWakePalette.Amber950
    val AlertImmediateSurface = RideWakePalette.Coral950

    // Text
    val TextPrimary = RideWakePalette.White
    val TextSecondary = RideWakePalette.Slate400
    val TextTertiary = RideWakePalette.Slate500
    val TextSoft = RideWakePalette.Slate300
    val TextMuted = RideWakePalette.Slate350
    val TripLabel = RideWakePalette.Slate425
    val TripActionText = RideWakePalette.Slate325

    // Structure
    val Border = RideWakePalette.Slate700
    val BorderOption = RideWakePalette.Slate750
    val TripActionBorder = RideWakePalette.Slate720

    // Predictive states
    val Success = RideWakePalette.Mint400
    val Warning = RideWakePalette.Amber400
    val Critical = RideWakePalette.Coral400

    // Disabled states
    val DisabledContainer = RideWakePalette.DisabledSurface
    val DisabledContent = RideWakePalette.DisabledContent
}