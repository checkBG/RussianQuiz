package com.example.russianquiz.model

private const val CURRENT_YEAR = 2025

object WrongAnswers {
    fun generateWrongAnswers(century: Century, rightAnswer: Int): List<Int> {
        val maxRange = if (century.yearRange <= CURRENT_YEAR) 100 else CURRENT_YEAR - century.yearRange
        return ((century.yearRange - 30..century.yearRange + maxRange).shuffled().take(5) + rightAnswer).shuffled()
    }
}