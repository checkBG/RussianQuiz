package com.example.russianquiz.model

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.example.russianquiz.R
import java.util.Locale

val LocalAppContext = compositionLocalOf<Context> { error("No context provided") }

enum class Language(
    @StringRes val text: Int,
    @DrawableRes val flagIcon: Int,
    val locale: String
) {
    ENGLISH(
        text = R.string.en,
        flagIcon = R.drawable.en,
        locale = "en"
    ),
    GERMAN(
        text = R.string.de,
        flagIcon = R.drawable.de,
        locale = "de"
    ),
    RUSSIAN(
        text = R.string.ru,
        flagIcon = R.drawable.ru,
        locale = "ru"
    ),
    UKRAINIAN(
        text = R.string.uk,
        flagIcon = R.drawable.uk,
        locale = "uk"
    )
}

fun Context.updateLocale(languagesCode: String): Context {
    val locale = Locale(languagesCode)
    Locale.setDefault(locale)

    val config = resources.configuration.apply {
        setLocale(locale)
        setLayoutDirection(locale)
    }
    return createConfigurationContext(config)
}

@Composable
fun LocalizedApp(
    languagesCode: String,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current.updateLocale(languagesCode)
    CompositionLocalProvider(value = LocalAppContext provides context) {
        content()
    }
}

@Suppress("Be careful with parameters")
@Composable
fun localizedString(@StringRes id: Int, vararg parameters: Any): String {
    val context = LocalAppContext.current
    return context.getString(id, *parameters.toList().toTypedArray())
}