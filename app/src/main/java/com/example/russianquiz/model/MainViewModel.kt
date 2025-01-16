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

    private val _answerOptions: MutableStateFlow<List<Int>> = MutableStateFlow(emptyList())
    val answersOptions: StateFlow<List<Int>>
        get() = _answerOptions.asStateFlow()

    fun updateCurrentCentury(century: Century) {
        if (century != quizData.value.chosenCentury) {
            _quizData.update {
                QuizData(
                    chosenCentury = century,
                    quizzes = StartQuiz.generateListOfQuizzes(century = century),
                )
            }
            _answerOptions.update {
                StartQuiz.generateWrongAnswers(
                    century = century,
                    rightAnswer = quizData.value.quizzes!![quizData.value.solvedQuestions].rightAnswer
                )
            }
        }
    }

    fun onChoosingOption(
        isRight: Boolean,
        chosenOption: Int,
        score: Int,
    ) {
        _quizData.update {
            if (isRight) it.copy(
                isCompleted = true,
                currentScore = it.currentScore + score,
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

        _answerOptions.update {
            StartQuiz.generateWrongAnswers(
                century = quizData.value.chosenCentury!!,
                rightAnswer = quizData.value.quizzes!![quizData.value.solvedQuestions].rightAnswer
            )
        }

        if (solvedQuestions == (quizData.value.quizzes?.size ?: 0)) {
            _answerOptions.update { emptyList() }
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