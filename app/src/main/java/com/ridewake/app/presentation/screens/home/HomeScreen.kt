package com.ridewake.app.presentation.screens.home

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakePalette
import com.ridewake.app.presentation.theme.RideWakeTypography

@Composable
fun HomeScreen(
    onStartTrip: () -> Unit = {},
    onOpenSettings: () -> Unit = {}
) {
    val infiniteTransition = rememberInfiniteTransition(label = "home_pulse")

    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 0.94f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.70f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

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
                horizontal = 24.dp,
                vertical = 14.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        // Breathing pulse background glow effect
        Box(
            modifier = Modifier
                .size(110.dp)
                .drawBehind {
                    drawCircle(
                        color = RideWakePalette.Cyan500.copy(alpha = pulseAlpha),
                        radius = size.minDimension * 0.5f * pulseScale
                    )
                }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.home_brand),
                color = RideWakeColors.Primary,
                style = RideWakeTypography.Brand,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = stringResource(R.string.home_greeting),
                modifier = Modifier.fillMaxWidth(0.90f),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.Hero,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = stringResource(R.string.home_description),
                modifier = Modifier.fillMaxWidth(0.80f),
                color = RideWakeColors.TextSecondary,
                style = RideWakeTypography.LabelRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Button(
                onClick = onStartTrip,
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .height(40.dp),
                shape = RoundedCornerShape(50),
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
                modifier = Modifier.height(10.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.48f)
                    .height(30.dp)
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
