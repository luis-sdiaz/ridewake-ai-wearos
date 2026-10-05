package com.ridewake.app.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors

@Composable
fun HomeScreen(
    onStartTrip: () -> Unit = {}
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
                horizontal = 24.dp,
                vertical = 14.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Brand
            Text(
                text = stringResource(R.string.home_brand),
                color = RideWakeColors.Primary,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.6.sp
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // AI indicator
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        color = RideWakeColors.Surface,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = RideWakeColors.Primary,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AI",
                    color = RideWakeColors.Primary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // Main message
            Text(
                text = stringResource(R.string.home_greeting),
                color = RideWakeColors.TextPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            // Predictive AI status
            Box(
                modifier = Modifier
                    .background(
                        color = RideWakeColors.SurfaceVariant,
                        shape = CircleShape
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.ai_status),
                    color = RideWakeColors.Success,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            // Primary action
            Button(
                onClick = onStartTrip,
                modifier = Modifier
                    .width(118.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RideWakeColors.Primary,
                    contentColor = RideWakeColors.OnPrimary
                )
            ) {
                Text(
                    text = stringResource(R.string.start_trip),
                    modifier = Modifier.fillMaxWidth(),
                    color = RideWakeColors.OnPrimary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}