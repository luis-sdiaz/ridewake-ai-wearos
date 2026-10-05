package com.ridewake.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R
import com.ridewake.app.presentation.theme.RideWakeColors
import com.ridewake.app.presentation.theme.RideWakeTypography

enum class PredictiveAlertLevel {
    EARLY,
    NEAR,
    IMMEDIATE
}

@Composable
fun PredictiveAlertCard(
    level: PredictiveAlertLevel,
    modifier: Modifier = Modifier
) {
    val title = when (level) {
        PredictiveAlertLevel.EARLY ->
            stringResource(R.string.alert_early)

        PredictiveAlertLevel.NEAR ->
            stringResource(R.string.alert_near)

        PredictiveAlertLevel.IMMEDIATE ->
            stringResource(R.string.alert_immediate)
    }

    val description = when (level) {
        PredictiveAlertLevel.EARLY ->
            stringResource(R.string.alert_early_description)

        PredictiveAlertLevel.NEAR ->
            stringResource(R.string.alert_near_description)

        PredictiveAlertLevel.IMMEDIATE ->
            stringResource(R.string.alert_immediate_description)
    }

    val accentColor = when (level) {
        PredictiveAlertLevel.EARLY ->
            RideWakeColors.Primary

        PredictiveAlertLevel.NEAR ->
            RideWakeColors.Warning

        PredictiveAlertLevel.IMMEDIATE ->
            RideWakeColors.Critical
    }

    val backgroundColor = when (level) {
        PredictiveAlertLevel.EARLY ->
            RideWakeColors.AlertEarlySurface

        PredictiveAlertLevel.NEAR ->
            RideWakeColors.AlertNearSurface

        PredictiveAlertLevel.IMMEDIATE ->
            RideWakeColors.AlertImmediateSurface
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = accentColor,
                shape = RoundedCornerShape(18.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 4.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = accentColor,
            style = RideWakeTypography.LabelStrong,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(1.dp)
        )

        Text(
            text = description,
            color = RideWakeColors.TextSoft,
            style = RideWakeTypography.Caption,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}