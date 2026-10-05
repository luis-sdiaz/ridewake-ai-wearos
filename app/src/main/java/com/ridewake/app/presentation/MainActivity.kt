package com.ridewake.app.presentation

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ridewake.app.presentation.screens.home.HomeScreen
import com.ridewake.app.presentation.theme.RideWakeAITheme
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(applyAppLanguage(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RideWakeAITheme {
                HomeScreen()
            }
        }
    }
}

private fun applyAppLanguage(context: Context): Context {
    val preferences = context.getSharedPreferences(
        "app_settings",
        Context.MODE_PRIVATE
    )

    val languageCode = preferences.getString(
        "app_language",
        "es"
    ) ?: "es"

    val locale = Locale.forLanguageTag(languageCode)

    Locale.setDefault(locale)

    val configuration = Configuration(
        context.resources.configuration
    ).apply {
        setLocale(locale)
        setLayoutDirection(locale)
    }

    return context.createConfigurationContext(configuration)
}