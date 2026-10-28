package com.ridewake.app.core.haptics

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import com.ridewake.app.presentation.components.PredictiveAlertLevel

class HapticFeedbackManager(private val context: Context) {
    private val vibrator: Vibrator? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
        vibratorManager?.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }

    fun playAlertPattern(level: PredictiveAlertLevel) {
        if (vibrator?.hasVibrator() != true) return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val effect = when (level) {
                PredictiveAlertLevel.EARLY -> {
                    VibrationEffect.createWaveform(longArrayOf(0, 100), intArrayOf(120), -1)
                }
                PredictiveAlertLevel.NEAR -> {
                    VibrationEffect.createWaveform(longArrayOf(0, 160, 100, 160), intArrayOf(0, 180, 0, 180), -1)
                }
                PredictiveAlertLevel.IMMEDIATE -> {
                    VibrationEffect.createWaveform(longArrayOf(0, 220, 80, 220, 80, 220), intArrayOf(0, 255, 0, 255, 0, 255), -1)
                }
            }
            vibrator.vibrate(effect)
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(300)
        }
    }

    fun playArrivalPattern() {
        if (vibrator?.hasVibrator() != true) return

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val effect = VibrationEffect.createWaveform(
                longArrayOf(0, 300, 100, 300, 100, 500),
                intArrayOf(0, 255, 0, 255, 0, 255),
                -1
            )
            vibrator.vibrate(effect)
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(800)
        }
    }
}
