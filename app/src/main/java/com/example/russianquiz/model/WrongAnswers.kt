package com.example.russianquiz.model

private const val CURRENT_YEAR = 2025

object WrongAnswers {
    fun generateWrongAnswers(century: Century, rightAnswer: Int): List<Int> {
        if (rightAnswer in 800..CURRENT_YEAR) {
            val maxRange =
                if (century.yearRange <= CURRENT_YEAR) 100 else CURRENT_YEAR - century.yearRange
            return ((century.yearRange - 30..century.yearRange + maxRange).shuffled()
                .take(5) + rightAnswer).shuffled()
        } else {
            val wrongAnswers = mutableListOf<Int>()
            val variants = century.quizzes.shuffled()
            var index = 0
            while (wrongAnswers.size < 6) {
                if (variants[index].rightAnswer != rightAnswer && variants[index].rightAnswer !in (800..CURRENT_YEAR)) {
                    wrongAnswers.add(variants[index].rightAnswer)
                }
                index++
            }
            return wrongAnswers.shuffled()
        }
    }
}