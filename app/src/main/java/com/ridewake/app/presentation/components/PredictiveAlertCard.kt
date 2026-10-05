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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.Text
import com.ridewake.app.R

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
            Color(0xFF59D9FF)

        PredictiveAlertLevel.NEAR ->
            Color(0xFFFFC857)

        PredictiveAlertLevel.IMMEDIATE ->
            Color(0xFFFF6B6B)
    }

    val backgroundColor = when (level) {
        PredictiveAlertLevel.EARLY ->
            Color(0xFF0D252F)

        PredictiveAlertLevel.NEAR ->
            Color(0xFF2A2516)

        PredictiveAlertLevel.IMMEDIATE ->
            Color(0xFF2C191C)
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
            fontSize = 8.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(1.dp)
        )

        Text(
            text = description,
            color = Color(0xFFB6C4CA),
            fontSize = 6.sp,
            lineHeight = 7.sp,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}