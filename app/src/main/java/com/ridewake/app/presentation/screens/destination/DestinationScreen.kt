package com.ridewake.app.presentation.screens.destination

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
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
import java.util.Locale

@Composable
fun DestinationScreen(
    onContinue: (String) -> Unit = {}
) {
    val context = LocalContext.current

    var selectedId by remember {
        mutableStateOf<String?>(null)
    }

    var voiceDestination by remember {
        mutableStateOf<String?>(null)
    }

    val homeLabel = stringResource(
        R.string.destination_home
    )

    val universityLabel = stringResource(
        R.string.destination_university
    )

    val otherLabel = stringResource(
        R.string.destination_other
    )

    val voicePrompt = stringResource(
        R.string.voice_destination_prompt
    )

    val voiceLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val spokenText = result.data
                    ?.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS
                    )
                    ?.firstOrNull()

                if (!spokenText.isNullOrBlank()) {
                    voiceDestination = spokenText
                    selectedId = "other"
                }
            }
        }

    fun startVoiceRecognition() {
        val intent = Intent(
            RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        ).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault().toLanguageTag()
            )

            putExtra(
                RecognizerIntent.EXTRA_PROMPT,
                voicePrompt
            )
        }

        if (
            intent.resolveActivity(
                context.packageManager
            ) != null
        ) {
            voiceLauncher.launch(intent)
        }
    }

    val selectedDestination = when (selectedId) {
        "home" -> homeLabel

        "university" -> universityLabel

        "other" -> voiceDestination

        else -> null
    }

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
                horizontal = 22.dp,
                vertical = 8.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(
                    R.string.destination_title
                ),
                color = RideWakeColors.TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = stringResource(
                    R.string.destination_subtitle
                ),
                color = RideWakeColors.TextSecondary,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            DestinationOption(
                label = homeLabel,
                icon = "⌂",
                selected = selectedId == "home",
                onClick = {
                    selectedId = "home"
                }
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            DestinationOption(
                label = universityLabel,
                icon = "U",
                selected = selectedId == "university",
                onClick = {
                    selectedId = "university"
                }
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            DestinationOption(
                label = voiceDestination ?: otherLabel,
                icon = "MIC",
                selected = selectedId == "other",
                onClick = {
                    startVoiceRecognition()
                }
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {
                    selectedDestination?.let {
                        onContinue(it)
                    }
                },
                enabled = selectedDestination != null,
                modifier = Modifier
                    .fillMaxWidth(0.64f)
                    .height(36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RideWakeColors.Primary,
                    contentColor = RideWakeColors.OnPrimary,
                    disabledContainerColor =
                        RideWakeColors.DisabledContainer,
                    disabledContentColor =
                        RideWakeColors.DisabledContent
                )
            ) {
                Text(
                    text = stringResource(
                        R.string.destination_continue
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    color = if (selectedDestination != null) {
                        RideWakeColors.OnPrimary
                    } else {
                        RideWakeColors.DisabledContent
                    },
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun DestinationOption(
    label: String,
    icon: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (selected) {
        RideWakeColors.Primary
    } else {
        RideWakeColors.BorderOption
    }

    val backgroundColor = if (selected) {
        RideWakeColors.SurfaceSelected
    } else {
        RideWakeColors.SurfaceOption
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(0.80f)
            .height(34.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(17.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(17.dp)
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
                .size(24.dp)
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
                text = icon,
                color = if (selected) {
                    RideWakeColors.OnPrimary
                } else {
                    RideWakeColors.TextMuted
                },
                fontSize = if (icon == "MIC") {
                    6.sp
                } else {
                    10.sp
                },
                fontWeight = FontWeight.Bold,
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
            fontSize = 9.sp,
            fontWeight = if (selected) {
                FontWeight.Bold
            } else {
                FontWeight.Medium
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}