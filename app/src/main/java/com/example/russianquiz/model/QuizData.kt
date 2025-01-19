package com.example.russianquiz.model

data class QuizData(
    val chosenLevel: Levels?,
    val quizzes: List<Quiz>?,
    val chosenOption: Int = 0,
    val rightAnswers: Int = 0,
    val isCompleted: Boolean = false,
    val solvedQuestions: Int = 0,
) {
    companion object {
        fun initQuizData(): QuizData {
            return QuizData(
                chosenLevel = null,
                quizzes = null,
            )
        }
    }
}