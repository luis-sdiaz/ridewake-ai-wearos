package com.ridewake.app.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ridewake.app.core.localization.LanguageManager
import com.ridewake.app.presentation.navigation.RideWakeApp
import com.ridewake.app.presentation.theme.RideWakeAITheme

class MainActivity : ComponentActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(
            LanguageManager.applyLanguage(newBase)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RideWakeAITheme {
                RideWakeApp()
            }
        }
    }
}