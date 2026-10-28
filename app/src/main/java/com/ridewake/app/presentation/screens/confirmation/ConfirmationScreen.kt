package com.ridewake.app.presentation.screens.confirmation

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeGradients
import com.ridewake.app.presentation.theme.RideWakeTypography

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
                horizontal = 26.dp,
                vertical = 14.dp
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
                modifier = Modifier.fillMaxWidth(0.86f),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.CompactTitle,
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = stringResource(
                    R.string.confirmation_subtitle
                ),
                modifier = Modifier.fillMaxWidth(0.86f),
                color = RideWakeColors.TextSecondary,
                style = RideWakeTypography.LabelRegular,
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(0.84f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(
                        R.string.confirmation_destination_label
                    ),
                    modifier = Modifier.weight(1f),
                    color = RideWakeColors.TripLabel,
                    style = RideWakeTypography.Micro
                )

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(RideWakeColors.AlertEarlySurface)
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.confirmation_ready_tag),
                        color = RideWakeColors.Success,
                        style = RideWakeTypography.CaptionStrong
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.84f)
                    .height(38.dp)
                    .background(
                        color = RideWakeColors.Surface,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .border(
                        width = 1.5.dp,
                        brush = RideWakeGradients.cardBorderGlow,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(
                        horizontal = 12.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = destination,
                    color = RideWakeColors.TextPrimary,
                    style = RideWakeTypography.Value,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = onStartTrip,
                modifier = Modifier
                    .fillMaxWidth(0.70f)
                    .height(36.dp),
                shape = RoundedCornerShape(50),
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
                    style = RideWakeTypography.ButtonCompact,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        color = RideWakeColors.SurfaceStatus,
                        shape = CircleShape
                    )
                    .clickable {
                        onChangeDestination()
                    }
                    .padding(
                        horizontal = 12.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.confirmation_change_destination
                    ),
                    color = RideWakeColors.TextMuted,
                    style = RideWakeTypography.Label,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
