package com.ridewake.app.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * RideWake AI Typography System
 *
 * Semantic typography tokens designed for compact
 * Wear OS interfaces and quick-glance readability.
 */
object RideWakeTypography {

    // Home hero message
    val Hero = TextStyle(
        fontSize = 18.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold
    )

    // Main screen title
    val ScreenTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Bold
    )

    // Confirmation title
    val CompactTitle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    )

    // Active trip title
    val TripTitle = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold
    )

    // Brand identity
    val Brand = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.6.sp
    )

    // Prominent compact control
    val ProminentControl = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold
    )

    // Important values
    val Value = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )

    // Standard primary button
    val Button = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold
    )

    // Compact primary button
    val ButtonCompact = TextStyle(
        fontSize = 9.sp,
        fontWeight = FontWeight.Bold
    )

    // Regular supporting text
    val BodyRegular = TextStyle(
        fontSize = 9.sp,
        fontWeight = FontWeight.Normal
    )

    // Interactive option text
    val Body = TextStyle(
        fontSize = 9.sp,
        fontWeight = FontWeight.Medium
    )

    // Selected option text
    val BodyStrong = TextStyle(
        fontSize = 9.sp,
        fontWeight = FontWeight.Bold
    )

    // Standard status label
    val Label = TextStyle(
        fontSize = 8.sp,
        fontWeight = FontWeight.Medium
    )

    // Regular supporting label
    val LabelRegular = TextStyle(
        fontSize = 8.sp,
        lineHeight = 10.sp,
        fontWeight = FontWeight.Normal
    )

    // Emphasized status
    val LabelStrong = TextStyle(
        fontSize = 8.sp,
        fontWeight = FontWeight.Bold
    )

    // Small secondary information
    val Micro = TextStyle(
        fontSize = 7.sp,
        fontWeight = FontWeight.Medium
    )

    // Small regular information
    val MicroRegular = TextStyle(
        fontSize = 7.sp,
        fontWeight = FontWeight.Normal
    )

    // Small descriptions and metric labels
    val Caption = TextStyle(
        fontSize = 6.sp,
        lineHeight = 7.sp,
        fontWeight = FontWeight.Normal
    )

    // Tiny emphasized labels
    val CaptionStrong = TextStyle(
        fontSize = 6.sp,
        fontWeight = FontWeight.Bold
    )
}