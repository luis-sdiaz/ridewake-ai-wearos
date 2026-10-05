package com.ridewake.app.presentation.screens.trip

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.components.PredictiveAlertCard
import com.ridewake.app.presentation.components.PredictiveAlertLevel
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeTypography
import java.util.Locale

@Composable
fun TripScreen(
    destination: String,
    etaMinutes: Int = 12,
    distanceKm: Double = 3.2,
    alertLevel: PredictiveAlertLevel = PredictiveAlertLevel.EARLY,
    onEndTrip: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                horizontal = 28.dp,
                vertical = 10.dp
            ),
        contentAlignment = Alignment.Center
    ) {
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
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = stringResource(R.string.trip_destination_label),
                color = RideWakeColors.TripLabel,
                style = RideWakeTypography.MicroRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = destination,
                modifier = Modifier.fillMaxWidth(0.68f),
                color = RideWakeColors.Primary,
                style = RideWakeTypography.Value,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(0.76f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TripMetric(
                    modifier = Modifier.weight(1f),
                    value = "$etaMinutes min",
                    label = stringResource(R.string.trip_eta_label)
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

                TripMetric(
                    modifier = Modifier.weight(1f),
                    value = String.format(
                        Locale.getDefault(),
                        "%.1f km",
                        distanceKm
                    ),
                    label = stringResource(R.string.trip_distance_label)
                )
            }

            Spacer(
                modifier = Modifier.height(9.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.76f)
                    .background(
                        color = RideWakeColors.TripStatusSurface,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.trip_ai_monitoring),
                    color = RideWakeColors.Success,
                    style = RideWakeTypography.Micro,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            PredictiveAlertCard(
                level = alertLevel,
                modifier = Modifier.fillMaxWidth(0.76f)
            )

            Spacer(
                modifier = Modifier.height(9.dp)
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
                        horizontal = 15.dp,
                        vertical = 5.dp
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
                vertical = 6.dp
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
            modifier = Modifier.height(2.dp)
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