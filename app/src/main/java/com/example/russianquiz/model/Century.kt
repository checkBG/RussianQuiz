package com.example.russianquiz.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.russianquiz.R

enum class Century(
    val centuryNumber: Int,
    val yearRange: Int,
    var isFirstCompleted: Boolean = false,
    var isSecondCompleted: Boolean = false,
    var isThirdCompleted: Boolean = false,
    var maxScore: Int = 0,
    val colors: List<Color>,
    val quizzes: List<Quiz>,
) {
    NINTH(
        centuryNumber = 9,
        yearRange = 801,
        colors = listOf(
            Color(0xFF6600ff),
            Color(0xFF6600ff),
            Color(0xFF138808),
            Color(0xFFfde910),
        ),
        quizzes = Quizzes.quizzes_ninth_century,
    ),
    TENTH(
        centuryNumber = 10,
        yearRange = 901,
        colors = listOf(
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
            Color(0xFFea8df7),
            Color(0xFFea8df7),
        ),
        quizzes = Quizzes.quizzes_tenth_century,
    ),
    ELEVENTH(
        centuryNumber = 11,
        yearRange = 1001,
        colors = listOf(
            Color(0xFFea8df7),
            Color(0xFFea8df7),
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
        ),
        quizzes = Quizzes.quizzes_eleventh_century,
    ),
    TWELFTH(
        centuryNumber = 12,
        yearRange = 1101,
        colors = listOf(
            Color(0xFF00008b),
            Color(0xFFc154c1),
        ),
        quizzes = Quizzes.quizzes_twelfth_century,
    ),
    THIRTEENTH(
        centuryNumber = 13,
        yearRange = 1201,
        colors = listOf(
            Color(0xFF996666),
            Color(0xFF996666),
            Color(0xFFffdc33),
            Color(0xFFefd334),
        ),
        quizzes = Quizzes.quizzes_thirteenth_century,
    ),
    FOURTEENTH(
        centuryNumber = 14,
        yearRange = 1301,
        colors = listOf(
            Color(0xFF966a57),
            Color(0xFFcd7f32),
            Color(0xFFc0c0c0),
            Color(0xFFb0b7c6),
        ),
        quizzes = Quizzes.quizzes_fourteenth_century,
    ),
    FIFTEENTH(
        centuryNumber = 15,
        yearRange = 1401,
        colors = listOf(
            Color(0xFF8B4513),
            Color(0xFFFF4D00),
            Color(0xFFF8F32B),
        ),
        quizzes = Quizzes.quizzes_fifteenth_century,
    ),
    SIXTEENTH(
        centuryNumber = 16,
        yearRange = 1501,
        colors = listOf(
            Color(0xFF98fB98),
            Color(0xFFffC0CB),
            Color(0xFFFEFE22),
        ),
        quizzes = Quizzes.quizzes_sixteenth_century,
    ),
    SEVENTEENTH(
        centuryNumber = 17,
        yearRange = 1601,
        colors = listOf(
            Color(0xFF00FFFF),
            Color(0xFFFDE910),
        ),
        quizzes = Quizzes.quizzes_seventeenth_century,
    ),
    EIGHTEENTH(
        centuryNumber = 18,
        yearRange = 1701,
        colors = listOf(
            Color(0xFF95500c),
            Color(0xFFff2400),
            Color(0xAA98ff98),
            Color(0xFF98ff98),
        ),
        quizzes = Quizzes.quizzes_eighteenth_century,
    ),
    NINETEENTH(
        centuryNumber = 19,
        yearRange = 1801,
        colors = listOf(
            Color(0xFF1faee9),
            Color(0xFF48d1cc),
            Color(0xFF99ff99),
            Color(0xFFfde910),
        ),
        quizzes = Quizzes.quizzes_nineteenth_century,
    ),
    TWENTIETH(
        centuryNumber = 20,
        yearRange = 1901,
        colors = listOf(
            Color(0xFF7D1497),
            Color(0xFF7D1497),
            Color(0xFFFF6347),
            Color(0xFFC8A2C8),
            Color(0xFFFFC0CB),
        ),
        quizzes = Quizzes.quizzes_twentieth_century,
    ),
    TWENTY_FIRST(
        centuryNumber = 21,
        yearRange = 2001,
        colors = listOf(
            Color(0xFF99FF00),
            Color(0xFFFF0099)
        ),
        quizzes = Quizzes.quizzes_twenty_first_century,
    );

    fun isCompleted(rightAnswer: Int, answers: Int) {
        val reached = (rightAnswer / answers.toFloat() * 100f) >= 90f
        if (!isFirstCompleted) isFirstCompleted = reached
        else if (!isSecondCompleted) isSecondCompleted = reached
        else if (!isThirdCompleted) isThirdCompleted = reached
    }

    fun updateMaxScore(newMaxScore: Int) {
        maxScore = newMaxScore
    }
}