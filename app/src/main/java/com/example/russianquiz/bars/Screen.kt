package com.example.russianquiz.bars

import androidx.annotation.StringRes
import com.example.russianquiz.R

sealed class NavigationScreen(
    val route: String,
    @StringRes val titularName: Int,
) {
    data object ChooseScreen : NavigationScreen(
        route = Screen.CHOOSE_SCREEN.name,
        titularName = Screen.CHOOSE_SCREEN.titularName,
    )

    data object StatisticCenturyScreen : NavigationScreen(
        route = Screen.STATISTIC_CENTURY_SCREEN.name,
        titularName = Screen.STATISTIC_CENTURY_SCREEN.titularName
    )

    data object CenturyQuiz : NavigationScreen(
        route = Screen.CENTURY_QUIZ.name,
        titularName = Screen.CENTURY_QUIZ.titularName,
    )

    data object SettingsScreen : NavigationScreen(
        route = Screen.SETTINGS_SCREEN.name,
        titularName = Screen.SETTINGS_SCREEN.titularName,
    )

    data object ProfileScreen : NavigationScreen(
        route = Screen.PROFILE_SCREEN.name,
        titularName = Screen.PROFILE_SCREEN.titularName,
    )

    data object ResultScreen : NavigationScreen(
        route = Screen.RESULT_SCREEN.name,
        titularName = Screen.RESULT_SCREEN.titularName,
    )
}

enum class Screen(@StringRes val titularName: Int) {
    CHOOSE_SCREEN(titularName = R.string.choose_screen),
    STATISTIC_CENTURY_SCREEN(titularName = R.string.statistic_century_screen),
    CENTURY_QUIZ(titularName = R.string.century_quiz),
    SETTINGS_SCREEN(titularName = R.string.settings),
    PROFILE_SCREEN(titularName = R.string.profile),
    RESULT_SCREEN(titularName = R.string.result_screen)
}