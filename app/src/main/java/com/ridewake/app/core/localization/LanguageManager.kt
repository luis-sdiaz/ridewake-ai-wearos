package com.ridewake.app.core.localization

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LanguageManager {

    private const val PREFERENCES_NAME = "app_settings"
    private const val LANGUAGE_KEY = "app_language"

    const val SPANISH = "es"
    const val ENGLISH = "en"

    private const val DEFAULT_LANGUAGE = SPANISH

    fun getLanguage(context: Context): String {
        val preferences = context.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )

        return preferences.getString(
            LANGUAGE_KEY,
            DEFAULT_LANGUAGE
        ) ?: DEFAULT_LANGUAGE
    }

    fun setLanguage(
        context: Context,
        languageCode: String
    ) {
        if (
            languageCode != SPANISH &&
            languageCode != ENGLISH
        ) {
            return
        }

        context.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
            .edit()
            .putString(
                LANGUAGE_KEY,
                languageCode
            )
            .apply()
    }

    fun applyLanguage(
        context: Context
    ): Context {
        val languageCode = getLanguage(context)

        val locale = Locale.forLanguageTag(
            languageCode
        )

        Locale.setDefault(locale)

        val configuration = Configuration(
            context.resources.configuration
        ).apply {
            setLocale(locale)
            setLayoutDirection(locale)
        }

        return context.createConfigurationContext(
            configuration
        )
    }
}