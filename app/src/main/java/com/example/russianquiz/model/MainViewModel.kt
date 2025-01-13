package com.example.russianquiz.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    val centuries = Century.entries
    var rightAnswers = 0

    private val _chosenCentury = MutableStateFlow(QuizData(chosenCentury = null))
    val chosenCentury: StateFlow<QuizData>
        get() = _chosenCentury.asStateFlow()

    fun updateCurrentCentury(century: Century) {
        _chosenCentury.update { it.copy(chosenCentury = century) }
    }
}