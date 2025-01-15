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
    val centuries = Century.entries

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

    fun updateCurrentCentury(century: Century) {
        if (century != quizData.value.chosenCentury) {
            _quizData.update {
                it.copy(
                    chosenCentury = century,
                    quizzes = StartQuiz.generateListOfQuizzes(century = century),
                )
            }
        }
    }

    fun onChoosingOption(
        chosenOption: Int,
        rightAnswer: Int,
        quiz: Quiz,
    ) {
        _quizData.update {
            if (chosenOption == rightAnswer) it.copy(
                isCompleted = true,
                currentScore = it.currentScore + quiz.score,
                rightAnswers = it.rightAnswers + 1,
                solvedQuestions = it.solvedQuestions + 1,
            ) else it.copy(isCompleted = true)
        }
    }

    fun onNextQuestionClick(
        navController: NavHostController,
        solvedQuestions: Int,
    ) {
        _quizData.update {
            it.copy(isCompleted = false)
        }
        if (solvedQuestions == (quizData.value.quizzes?.size ?: 0)) {
            quizData.value.chosenCentury!!.updateMaxScore(newMaxScore = quizData.value.currentScore)
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