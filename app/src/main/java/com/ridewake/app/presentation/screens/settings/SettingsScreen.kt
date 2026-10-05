package com.ridewake.app.presentation.screens.settings

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeTypography

@Composable
fun SettingsScreen(
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit = {},
    onBack: () -> Unit = {}
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
                text = stringResource(R.string.settings_title),
                color = RideWakeColors.TextPrimary,
                style = RideWakeTypography.CompactTitle,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = stringResource(R.string.settings_language),
                color = RideWakeColors.Primary,
                style = RideWakeTypography.LabelStrong,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = stringResource(
                    R.string.settings_language_description
                ),
                modifier = Modifier.fillMaxWidth(0.78f),
                color = RideWakeColors.TextSecondary,
                style = RideWakeTypography.LabelRegular,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            LanguageOption(
                badge = "ES",
                label = stringResource(R.string.language_spanish),
                selected = currentLanguage == "es",
                onClick = {
                    onLanguageSelected("es")
                }
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            LanguageOption(
                badge = "EN",
                label = stringResource(R.string.language_english),
                selected = currentLanguage == "en",
                onClick = {
                    onLanguageSelected("en")
                }
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        color = RideWakeColors.TripActionSurface
                    )
                    .border(
                        width = 1.dp,
                        color = RideWakeColors.TripActionBorder,
                        shape = CircleShape
                    )
                    .clickable {
                        onBack()
                    }
                    .padding(
                        horizontal = 15.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.settings_back),
                    color = RideWakeColors.TripActionText,
                    style = RideWakeTypography.Micro,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun LanguageOption(
    badge: String,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val optionShape = RoundedCornerShape(18.dp)

    val backgroundColor = if (selected) {
        RideWakeColors.SurfaceSelected
    } else {
        RideWakeColors.SurfaceOption
    }

    val borderColor = if (selected) {
        RideWakeColors.Primary
    } else {
        RideWakeColors.BorderOption
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(0.78f)
            .height(38.dp)
            .clip(optionShape)
            .background(
                color = backgroundColor,
                shape = optionShape
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = optionShape
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 7.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(25.dp)
                .background(
                    color = if (selected) {
                        RideWakeColors.Primary
                    } else {
                        RideWakeColors.SurfaceIcon
                    },
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = badge,
                color = if (selected) {
                    RideWakeColors.OnPrimary
                } else {
                    RideWakeColors.TextMuted
                },
                style = RideWakeTypography.CaptionStrong,
                textAlign = TextAlign.Center
            )
        }

        Spacer(
            modifier = Modifier.size(8.dp)
        )

        Text(
            text = label,
            modifier = Modifier.weight(1f),
            color = RideWakeColors.TextPrimary,
            style = if (selected) {
                RideWakeTypography.BodyStrong
            } else {
                RideWakeTypography.Body
            }
        )

        if (selected) {
            Text(
                text = "✓",
                color = RideWakeColors.Primary,
                style = RideWakeTypography.LabelStrong
            )
        }
    }
}