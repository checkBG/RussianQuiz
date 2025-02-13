package com.example.russianquiz.model

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.database.dao.SettingsDataDao
import com.example.russianquiz.model.database.entity.SettingsDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val dao: SettingsDataDao,
) : ViewModel() {
    val levels = Levels.entries

    val settingsData = dao.getSettings()
        .map { settings ->
            val languageIndex = settings?.languageIndex ?: 0
            val language = Languages.entries.getOrNull(languageIndex) ?: Languages.ENGLISH

            SettingsData(language = language)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), SettingsData())

    private val _settingsData = MutableStateFlow(settingsData.value)

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

//    init {
//        println("settings ${settingsData.value}")
//        viewModelScope.launch {
//            settingsData.collectLatest { settingsData ->
//                _settingsData.value = settingsData
//            }
//        }
//        println("settings ${settingsData.value}")
//    }

    fun getFavouriteLevel(): Int {
        var maxCompleted = 0
        var maxLevelCompleted = 0
        settingsData.value.profile.completedLevels.forEach { (level, count) ->
            if (count >= maxCompleted) {
                maxCompleted = count
                maxLevelCompleted = level.ordinal + 1
            }
        }
        return maxLevelCompleted
    }

    fun changeChosenPhoto(bitmap: Bitmap) {
        _settingsData.update {
            it.copy(profile = it.profile.copy(chosenPhotoProfile = bitmap))
        }
    }

    fun changeLanguage(language: Languages) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.saveSettings(
                    settings = SettingsDataEntity(
                        id = 1,
                        languageIndex = language.ordinal
                    )
                )
            }
        }
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