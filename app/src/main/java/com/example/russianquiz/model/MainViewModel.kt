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

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

    fun updateCurrentLevel(level: Levels) {
        if (level != quizData.value.chosenLevel) {
            _quizData.update {
                QuizData(
                    chosenLevel = level,
                    quizzes = level.quizzes.shuffled(),
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
        solvedQuestions: Int,
    ) {
        _quizData.update {
            it.copy(
                isCompleted = false,
                solvedQuestions = it.solvedQuestions + 1
            )
        }

        if (solvedQuestions == (quizData.value.quizzes?.size ?: 0)) {
            _quizData.update { QuizData.initQuizData() }
            navController.navigate(NavigationScreen.ResultScreen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
            }
        }
    }
}