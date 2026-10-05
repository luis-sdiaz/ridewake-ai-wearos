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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.components.PredictiveAlertCard
import com.ridewake.app.presentation.components.PredictiveAlertLevel
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
                        Color(0xFF123442),
                        Color(0xFF071015),
                        Color(0xFF020405)
                    )
                )
            )
            .padding(
                horizontal = 28.dp,
                vertical = 14.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.trip_title),
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = stringResource(R.string.trip_destination_label),
                color = Color(0xFF8FA3AC),
                fontSize = 7.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(1.dp)
            )

            Text(
                text = destination,
                modifier = Modifier.fillMaxWidth(0.68f),
                color = Color(0xFF59D9FF),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(
                modifier = Modifier.height(6.dp)
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
                    modifier = Modifier.width(5.dp)
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
                modifier = Modifier.height(6.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.76f)
                    .background(
                        color = Color(0xFF102A33),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.trip_ai_monitoring),
                    color = Color(0xFF72E4C1),
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            PredictiveAlertCard(
                level = alertLevel,
                modifier = Modifier.fillMaxWidth(0.76f)
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFF101D22),
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1B333D),
                        shape = CircleShape
                    )
                    .clickable {
                        onEndTrip()
                    }
                    .padding(
                        horizontal = 14.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.trip_end),
                    color = Color(0xFFA9BBC2),
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Medium,
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
                color = Color(0xFF0C2028),
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF193A46),
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
            color = Color.White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(1.dp)
        )

        Text(
            text = label,
            color = Color(0xFF82959E),
            fontSize = 6.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}