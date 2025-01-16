package com.example.russianquiz.model

data class QuizData(
    val chosenCentury: Century?,
    val quizzes: List<Quiz>?,
    val chosenOption: Int = 0,
    val currentScore: Int = 0,
    val rightAnswers: Int = 0,
    val isCompleted: Boolean = false,
    val solvedQuestions: Int = 0,
) {
    companion object {
        fun initQuizData(): QuizData {
            return QuizData(
                chosenCentury = null,
                quizzes = null,
            )
        }
    }
}