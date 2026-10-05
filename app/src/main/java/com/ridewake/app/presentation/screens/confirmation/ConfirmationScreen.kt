package com.ridewake.app.presentation.screens.confirmation

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors

@Composable
fun ConfirmationScreen(
    destination: String,
    onStartTrip: () -> Unit = {},
    onChangeDestination: () -> Unit = {}
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
                horizontal = 30.dp,
                vertical = 16.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(
                    R.string.confirmation_title
                ),
                modifier = Modifier.fillMaxWidth(0.82f),
                color = RideWakeColors.TextPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = stringResource(
                    R.string.confirmation_subtitle
                ),
                modifier = Modifier.fillMaxWidth(0.82f),
                color = RideWakeColors.TextSecondary,
                fontSize = 8.sp,
                textAlign = TextAlign.Center,
                lineHeight = 10.sp
            )

            Spacer(
                modifier = Modifier.height(11.dp)
            )

            Text(
                text = stringResource(
                    R.string.confirmation_destination_label
                ),
                color = RideWakeColors.Success,
                fontSize = 8.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .height(40.dp)
                    .background(
                        color = RideWakeColors.Surface,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = RideWakeColors.Primary,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(
                        horizontal = 12.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = destination,
                    color = RideWakeColors.TextPrimary,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(
                modifier = Modifier.height(9.dp)
            )

            Button(
                onClick = onStartTrip,
                modifier = Modifier
                    .fillMaxWidth(0.64f)
                    .height(36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RideWakeColors.Primary,
                    contentColor = RideWakeColors.OnPrimary
                )
            ) {
                Text(
                    text = stringResource(
                        R.string.confirmation_start_trip
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    color = RideWakeColors.OnPrimary,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = RideWakeColors.SurfaceStatus,
                        shape = CircleShape
                    )
                    .clickable {
                        onChangeDestination()
                    }
                    .padding(
                        horizontal = 11.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.confirmation_change_destination
                    ),
                    color = RideWakeColors.TextMuted,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}