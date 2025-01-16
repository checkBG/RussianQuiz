package com.example.russianquiz.model

private const val CURRENT_YEAR = 2025
private const val FIRST_IS_NOT_COMPLETED = 20
private const val SECOND_IS_NOT_COMPLETED = 35
private const val THIRD_IS_NOT_COMPLETED = 50
private const val COUNT_OF_WRONG_QUESTIONS = 5

object StartQuiz {
    private fun getCountOfQuizzes(century: Century): Int {
        return if (!century.isFirstCompleted) {
            FIRST_IS_NOT_COMPLETED
        } else if (!century.isSecondCompleted) {
            SECOND_IS_NOT_COMPLETED
        } else {
            THIRD_IS_NOT_COMPLETED
        }
    }

    fun generateListOfQuizzes(
        century: Century,
    ): List<Quiz> =
        century.quizzes.shuffled().take(getCountOfQuizzes(century = century))

    fun generateWrongAnswers(century: Century, rightAnswer: Int): List<Int> {
        if (rightAnswer in 800..CURRENT_YEAR) {
            val maxRange =
                if (century.yearRange <= CURRENT_YEAR) 100 else CURRENT_YEAR - century.yearRange
            return ((century.yearRange - 30..century.yearRange + maxRange).shuffled()
                .take(COUNT_OF_WRONG_QUESTIONS) + rightAnswer).shuffled()
        } else {
            val wrongAnswers = mutableListOf<Int>()
            val variants = century.quizzes.shuffled()
            var index = 0
            while (wrongAnswers.size < COUNT_OF_WRONG_QUESTIONS) {
                if (variants[index].rightAnswer != rightAnswer && variants[index].rightAnswer !in (800..CURRENT_YEAR)) {
                    wrongAnswers.add(variants[index].rightAnswer)
                }
                index++
            }
            return wrongAnswers.shuffled() + rightAnswer
        }
    }
}