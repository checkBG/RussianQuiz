package com.example.russianquiz.model

import android.graphics.Bitmap
import androidx.navigation.NavHostController

sealed interface UserAction {
    // ui handle
    data object ShowDialog : UserAction
    data object HideDialog : UserAction
    data object ShowExplanation : UserAction
    data object HideExplanation : UserAction

    // action handle
    data class SelectLevel(val level: Level, val navController: NavHostController) : UserAction
    data class SelectOption(val answerOption: Int) : UserAction
    data class PressNextButton(val navController: NavHostController, val isFinished: Boolean = false) : UserAction
    data class ChangeLanguage(val language: Language) : UserAction
    data class PressPlayAgain(val chosenLevel: Level, val navController: NavHostController) : UserAction
    data class ResetResult(val navController: NavHostController, val route: String) : UserAction
    data class ChangePhoto(val bitmap: Bitmap) : UserAction
    data class ChangeQuizCount(val count: Int) : UserAction
}