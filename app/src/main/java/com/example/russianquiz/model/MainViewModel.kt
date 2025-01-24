package com.example.russianquiz.model

import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.russianquiz.bars.NavigationScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    val levels = Levels.entries
    private val _language = MutableStateFlow("en")
    val language: StateFlow<String>
        get() = _language.asStateFlow()

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

    fun changeLanguage(languageCode: String) {
        _language.value = languageCode
    }

    fun updateCurrentLevel(level: Levels) {
        if (level != quizData.value.chosenLevel) {
            _quizData.update {
                QuizData(
                    chosenLevel = level,
                    quizzes = level.quizzes.shuffled().take(10),
                )
            }
        }
    }

    fun onChoosingOption(
        isRight: Boolean,
        chosenOption: Int,
    ) {
        _quizData.update {
            if (isRight) it.copy(
                isCompleted = true,
                rightAnswers = it.rightAnswers + 1,
                chosenOption = chosenOption,
            ) else it.copy(
                isCompleted = true,
                chosenOption = chosenOption,
            )
        }
    }

    fun onNextQuestionClick(
        navController: NavHostController,
        isFinished: Boolean = false,
    ) {
        if (((quizData.value.solvedQuestions + 1) == quizData.value.quizzes.size) || isFinished) {
            navController.navigate(NavigationScreen.ResultScreen.route)
            {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
            }
            return
        }
        _quizData.update {
            it.copy(
                isCompleted = false,
                solvedQuestions = it.solvedQuestions + 1,
                chosenOption = 0,
            )
        }
    }

    fun resetResult() {
        _quizData.value = QuizData.initQuizData()
    }


}