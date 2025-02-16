package com.example.russianquiz.model

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.russianquiz.bars.NavigationScreen
import com.example.russianquiz.model.database.dao.SettingsDataDao
import com.example.russianquiz.utils.BitmapConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val dao: SettingsDataDao,
) : ViewModel() {
    val levels = Level.entries

    val settingsData = dao.getSettings()
        .map { settings ->
            val languageIndex = settings.settings.languageIndex
            val language = getLanguageByIndex(languageIndex) ?: Language.ENGLISH

            val chosenPhotoProfile = BitmapConverter().toBitmap(settings.settings.avatar)
            val solvedQuestions = settings.settings.solvedQuestions
            val rightAnswers = settings.settings.rightAnswers
            val completedLevels = settings.completedLevels

            SettingsData(
                language = language,
                profile = Profile(
                    chosenPhotoProfile = chosenPhotoProfile,
                    solvedQuestions = solvedQuestions,
                    rightAnswers = rightAnswers,
                    completedLevels = completedLevels
                )
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), SettingsData())

    private val _settingsData = MutableStateFlow(settingsData.value)

    private val _quizData = MutableStateFlow(QuizData.initQuizData())
    val quizData: StateFlow<QuizData>
        get() = _quizData.asStateFlow()

    private fun getLanguageByIndex(index: Int): Language? {
        return Language.entries.getOrNull(index)
    }

    fun getFavouriteLevel(): Int {
        var maxCompleted = 0
        var maxLevelCompleted = 0
        settingsData.value.profile.completedLevels.forEach {
            if (it.completed >= maxCompleted) {
                maxCompleted = it.completed
                maxLevelCompleted = it.id + 1
            }
        }
        return maxLevelCompleted
    }

    fun changeChosenPhoto(bitmap: Bitmap) {
        viewModelScope.launch {
            dao.updateChosenAvatar(avatar = BitmapConverter().fromBitmap(bitmap))
        }
    }

    fun changeLanguage(language: Language) {
        viewModelScope.launch {
            dao.saveSelectedLanguage(languageIndex = language.ordinal)
        }
    }

    fun updateCurrentLevel(level: Level) {
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
            currentSettings.copy(
                isCompleted = true,
                chosenOption = chosenOption,
                rightAnswers = currentSettings.rightAnswers + if (isRight) 1 else 0
            )
        }
        viewModelScope.launch {
            if (isRight) {
                // UPDATING in db :rightAnswers
                dao.updateRightAnswers()
            }
            // UPDATING in db :solvedQuestions
            dao.updateSolvedQuestions()
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
                viewModelScope.launch {
                    dao.saveCompletedLevels(quizData.value.chosenLevel.ordinal)
                }
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
        }
    }

    fun resetResult() {
        _quizData.value = QuizData.initQuizData()
    }
}