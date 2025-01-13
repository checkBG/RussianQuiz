package com.example.russianquiz.model

data class QuizData(
    val chosenCentury: Century?,
    val currentScore: Int = 0,
    val rightAnswers: Int = 0,
)