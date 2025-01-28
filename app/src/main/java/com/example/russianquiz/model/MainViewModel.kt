package com.example.russianquiz.model

import android.graphics.Bitmap
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
    private val _settingsData = MutableStateFlow(SettingsData())
    val settingsData: StateFlow<SettingsData>
        get() = _settingsData.asStateFlow()

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

    fun changeChosenPhoto(bitmap: Bitmap) {
        _settingsData.update {
            it.copy(profile = it.profile.copy(chosenPhotoProfile = bitmap))
        }
    }

    fun changeLanguage(language: Languages) {
        _settingsData.update {
            it.copy(language = language)
        }
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
        _quizData.update { currentSettings ->
            if (isRight) {
                currentSettings.copy(
                    isCompleted = true,
                    rightAnswers = currentSettings.rightAnswers + 1,
                    chosenOption = chosenOption,
                ).also {
                    _settingsData.update {
                        it.copy(
                            profile = it.profile.copy(
                                rightAnswers = it.profile.rightAnswers.inc()
                            )
                        )
                    }
                }
            } else {
                currentSettings.copy(
                    isCompleted = true,
                    chosenOption = chosenOption,
                )
            }
        }
    }

    fun onNextQuestionClick(
        navController: NavHostController,
        isFinished: Boolean = false,
    ) {
        if (((quizData.value.solvedQuestions + 1) == quizData.value.quizzes.size) || isFinished) {
            navController.navigate(NavigationScreen.ResultScreen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
            }
            if ((quizData.value.solvedQuestions + 1) == quizData.value.quizzes.size && (!isFinished || quizData.value.chosenOption == 0)) {
                settingsData.value.profile.completedLevel(quizData.value.chosenLevel)
            }
            _settingsData.update {
                it.copy(
                    profile = it.profile.copy(
                        solvedQuestions = it.profile.solvedQuestions.inc()
                    )
                )
            }
            return
        }

        _quizData.update {
            it.copy(
                isCompleted = false,
                solvedQuestions = if (quizData.value.chosenOption != 0) {
                    it.solvedQuestions.inc()
                } else it.solvedQuestions,
                chosenOption = 0,
            )
        }.also {
            _settingsData.update { currentSettings ->
                currentSettings.copy(
                    profile = currentSettings.profile.copy(
                        solvedQuestions = currentSettings.profile.solvedQuestions.inc(),
                    )
                )
            }
        }
    }

    fun resetResult() {
        _quizData.value = QuizData.initQuizData()
    }
}