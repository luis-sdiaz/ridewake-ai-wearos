package com.ridewake.app.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeTypography

@Composable
fun HomeScreen(
    onStartTrip: () -> Unit = {},
    onOpenSettings: () -> Unit = {}
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
                horizontal = 26.dp,
                vertical = 18.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.home_brand),
                color = RideWakeColors.Primary,
                style = RideWakeTypography.Brand,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = stringResource(R.string.home_greeting),
                modifier = Modifier.fillMaxWidth(0.88f),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.Hero,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(9.dp)
            )

            Text(
                text = stringResource(R.string.home_description),
                modifier = Modifier.fillMaxWidth(0.76f),
                color = RideWakeColors.TextSecondary,
                style = RideWakeTypography.LabelRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Button(
                onClick = onStartTrip,
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .height(42.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RideWakeColors.Primary,
                    contentColor = RideWakeColors.OnPrimary
                )
            ) {
                Text(
                    text = stringResource(R.string.start_trip),
                    modifier = Modifier.fillMaxWidth(),
                    color = RideWakeColors.OnPrimary,
                    style = RideWakeTypography.ProminentControl,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.44f)
                    .height(32.dp)
                    .clip(CircleShape)
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
                        onOpenSettings()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.settings_title),
                    color = RideWakeColors.TripActionText,
                    style = RideWakeTypography.ButtonCompact,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}