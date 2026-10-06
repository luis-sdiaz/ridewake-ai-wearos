package com.ridewake.app.presentation.screens.location

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
fun LocationPermissionScreen(
    onRequestPermission: () -> Unit = {},
    onNotNow: () -> Unit = {}
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
                vertical = 12.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(
                    R.string.location_permission_title
                ),
                modifier = Modifier.fillMaxWidth(0.82f),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.CompactTitle,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(7.dp)
            )

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
                    text = "◎",
                    color = RideWakeColors.Primary,
                    style = RideWakeTypography.ProminentControl,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = stringResource(
                    R.string.location_permission_description
                ),
                modifier = Modifier.fillMaxWidth(0.82f),
                color = RideWakeColors.TextSecondary,
                style = RideWakeTypography.LabelRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(7.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.78f)
                    .background(
                        color = RideWakeColors.SurfaceVariant,
                        shape = CircleShape
                    )
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.location_permission_precise
                    ),
                    color = RideWakeColors.Success,
                    style = RideWakeTypography.Caption,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = onRequestPermission,
                modifier = Modifier
                    .fillMaxWidth(0.68f)
                    .height(36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RideWakeColors.Primary,
                    contentColor = RideWakeColors.OnPrimary
                )
            ) {
                Text(
                    text = stringResource(
                        R.string.location_permission_allow
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
                    .clickable {
                        onNotNow()
                    }
                    .padding(
                        horizontal = 12.dp,
                        vertical = 4.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(
                        R.string.location_permission_not_now
                    ),
                    color = RideWakeColors.TextSecondary,
                    style = RideWakeTypography.Micro,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}