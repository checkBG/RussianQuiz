package com.example.russianquiz.bars

sealed class NavigationScreen(
    val route: String,
) {
    data object ChooseScreen : NavigationScreen(
        route = Screen.CHOOSE_SCREEN.name,
    )

    data object StatisticCenturyScreen : NavigationScreen(
        route = Screen.STATISTIC_CENTURY_SCREEN.name,
    )

    data object CenturyQuiz : NavigationScreen(
        route = Screen.CENTURY_QUIZ.name,
    )

    data object SettingsScreen : NavigationScreen(
        route = Screen.SETTINGS_SCREEN.name,
    )

    data object ProfileScreen : NavigationScreen(
        route = Screen.PROFILE_SCREEN.name,
    )

    data object ResultScreen : NavigationScreen(
        route = Screen.RESULT_SCREEN.name,
    )
}

enum class Screen {
    CHOOSE_SCREEN,
    STATISTIC_CENTURY_SCREEN,
    CENTURY_QUIZ,
    SETTINGS_SCREEN,
    PROFILE_SCREEN,
    RESULT_SCREEN,
}