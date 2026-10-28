package com.ridewake.app.presentation.screens.trip

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.core.haptics.HapticFeedbackManager
import com.ridewake.app.core.trip.model.TripState
import com.ridewake.app.presentation.components.PredictiveAlertCard
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeGradients
import com.ridewake.app.presentation.theme.RideWakePalette
import com.ridewake.app.presentation.theme.RideWakeTypography
import java.util.Locale

@Composable
fun TripScreen(
    tripState: TripState = TripState(),
    onEndTrip: () -> Unit = {}
) {
    val context = LocalContext.current
    val hapticManager = remember { HapticFeedbackManager(context) }

    val density = LocalDensity.current

    val shakeOffset = remember {
        Animatable(0f)
    }

    val shakeDistance = with(density) {
        4.dp.toPx()
    }

    val infiniteTransition = rememberInfiniteTransition(label = "trip_pulse")

    val dotAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "dot_alpha"
    )

    // Trigger physical haptic feedback on alert level change
    LaunchedEffect(tripState.alertLevel) {
        if (!tripState.isArrived) {
            hapticManager.playAlertPattern(tripState.alertLevel)
        }
    }

    // Trigger arrival haptic feedback
    LaunchedEffect(tripState.isArrived) {
        if (tripState.isArrived) {
            hapticManager.playArrivalPattern()
        }
    }

    LaunchedEffect(Unit) {
        shakeOffset.snapTo(0f)

        repeat(20) {
            shakeOffset.animateTo(
                targetValue = shakeDistance,
                animationSpec = tween(
                    durationMillis = 50
                )
            )

            shakeOffset.animateTo(
                targetValue = -shakeDistance,
                animationSpec = tween(
                    durationMillis = 50
                )
            )
        }

        shakeOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 80
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                translationX = shakeOffset.value
            }
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        RideWakeColors.BackgroundGlow,
                        RideWakeColors.BackgroundMiddle,
                        RideWakeColors.Background
                    )
                )
            )
            .padding(
                horizontal = 24.dp,
                vertical = 10.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        // Bezel Progress Arc along the curved watch edge driven by progressFraction
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 4.dp.toPx()
            val inset = strokeWidth * 0.75f
            val sweepAngle = 260f * tripState.progressFraction
            drawArc(
                brush = RideWakeGradients.progressSweep,
                startAngle = -220f,
                sweepAngle = if (tripState.isArrived) 260f else sweepAngle.coerceAtLeast(10f),
                useCenter = false,
                topLeft = androidx.compose.ui.geometry.Offset(inset, inset),
                size = androidx.compose.ui.geometry.Size(
                    size.width - inset * 2,
                    size.height - inset * 2
                ),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.trip_title),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.TripTitle,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = stringResource(
                    R.string.trip_destination_label
                ),
                color = RideWakeColors.TripLabel,
                style = RideWakeTypography.MicroRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(1.dp)
            )

            Text(
                text = tripState.destination.ifEmpty { "Casa" },
                modifier = Modifier.fillMaxWidth(0.72f),
                color = RideWakeColors.Primary,
                style = RideWakeTypography.Value,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(0.78f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TripMetric(
                    modifier = Modifier.weight(1f),
                    value = "${tripState.remainingMinutes} min",
                    label = stringResource(
                        R.string.trip_eta_label
                    )
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                TripMetric(
                    modifier = Modifier.weight(1f),
                    value = String.format(
                        Locale.getDefault(),
                        "%.1f km",
                        tripState.remainingDistanceKm
                    ),
                    label = stringResource(
                        R.string.trip_distance_label
                    )
                )
            }

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .background(
                        color = RideWakeColors.TripStatusSurface,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .background(
                                color = RideWakePalette.Mint400.copy(alpha = dotAlpha),
                                shape = CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = if (tripState.isArrived) {
                            stringResource(R.string.trip_arrived_title)
                        } else {
                            stringResource(R.string.trip_ai_monitoring)
                        },
                        color = RideWakeColors.Success,
                        style = RideWakeTypography.Micro,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            if (tripState.isArrived) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.78f)
                        .background(
                            color = RideWakeColors.AlertEarlySurface,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .border(
                            width = 1.5.dp,
                            color = RideWakeColors.Success,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.trip_arrived_title),
                        color = RideWakeColors.Success,
                        style = RideWakeTypography.LabelStrong,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = stringResource(R.string.trip_arrived_description),
                        color = RideWakeColors.TextSoft,
                        style = RideWakeTypography.Caption,
                        textAlign = TextAlign.Center,
                        maxLines = 2
                    )
                }
            } else {
                PredictiveAlertCard(
                    level = tripState.alertLevel,
                    modifier = Modifier.fillMaxWidth(0.78f)
                )
            }

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = RideWakeColors.TripActionSurface,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = RideWakeColors.TripActionBorder,
                        shape = CircleShape
                    )
                    .clickable {
                        onEndTrip()
                    }
                    .padding(
                        horizontal = 14.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.trip_end),
                    color = RideWakeColors.TripActionText,
                    style = RideWakeTypography.Micro,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun TripMetric(
    modifier: Modifier = Modifier,
    value: String,
    label: String
) {
    Column(
        modifier = modifier
            .background(
                color = RideWakeColors.Surface,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 1.dp,
                color = RideWakeColors.Border,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(
                horizontal = 4.dp,
                vertical = 5.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = RideWakeColors.TextPrimary,
            style = RideWakeTypography.Value,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(1.dp)
        )

        Text(
            text = label,
            color = RideWakeColors.TextTertiary,
            style = RideWakeTypography.Caption,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
