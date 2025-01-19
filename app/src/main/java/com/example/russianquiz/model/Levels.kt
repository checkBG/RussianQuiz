package com.example.russianquiz.model

import androidx.compose.ui.graphics.Color

enum class Levels(
    val colors: List<Color>,
    val quizzes: List<Quiz>,
) {
    FIRST_LEVEL(
        quizzes = Quizzes.firstLevelQuizzes,
        colors = listOf(
            Color(0xFF6600ff),
            Color(0xFF6600ff),
            Color(0xFF138808),
            Color(0xFFfde910),
        ),
    ),
    SECOND_LEVEL(
        quizzes = Quizzes.secondLevelQuizzes,
        colors = listOf(
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
            Color(0xFFea8df7),
            Color(0xFFea8df7),
        ),
    ),
    THIRD_LEVEL(
        quizzes = Quizzes.thirdLevelQuizzes,
        colors = listOf(
            Color(0xFF1faee9),
            Color(0xFF48d1cc),
            Color(0xFF99ff99),
            Color(0xFFfde910),
        ),
    ),
    FOURTH_LEVEL(
        quizzes = Quizzes.fourthLevelQuizzes,
        colors = listOf(
            Color(0xFF996666),
            Color(0xFF996666),
            Color(0xFFffdc33),
            Color(0xFFefd334),
        ),
    ),
    FIFTH_LEVEL(
        quizzes = Quizzes.fifthLevelQuizzes,
        colors = listOf(
            Color(0xFF95500c),
            Color(0xFFff2400),
            Color(0xAA98ff98),
            Color(0xFF98ff98),
        ),
    ),
    SIXTH_LEVEL(
        quizzes = Quizzes.sixthLevelQuizzes,
        colors = listOf(
            Color(0xFFea8df7),
            Color(0xFFea8df7),
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
        ),
    ),
    SEVENTH_LEVEL(
        quizzes = Quizzes.seventhLevelQuizzes,
        colors = listOf(
            Color(0xFF00008b),
            Color(0xFFc154c1),
        ),
    ),
    EIGHTH_LEVEL(
        quizzes = Quizzes.eighthLevelQuizzes,
        colors = listOf(
            Color(0xFF99FF00),
            Color(0xFFFF0099)
        ),
    ),
    NINTH_LEVEL(
        quizzes = Quizzes.ninthLevelQuizzes,
        colors = listOf(
            Color(0xFF966a57),
            Color(0xFFcd7f32),
            Color(0xFFc0c0c0),
            Color(0xFFb0b7c6),
        ),
    ),
    TENTH_LEVEL(
        quizzes = Quizzes.tenthLevelQuizzes,
        colors = listOf(
            Color(0xFF7D1497),
            Color(0xFF7D1497),
            Color(0xFFFF6347),
            Color(0xFFC8A2C8),
            Color(0xFFFFC0CB),
        ),
    );
}

//        colors = listOf(
//            Color(0xFF8B4513),
//            Color(0xFFFF4D00),
//            Color(0xFFF8F32B),
//        ),
//        colors = listOf(
//            Color(0xFF98fB98),
//            Color(0xFFffC0CB),
//            Color(0xFFFEFE22),
//        ),
//        colors = listOf(
//            Color(0xFF00FFFF),
//            Color(0xFFFDE910),
//        ),
//        colors = listOf(
//            Color(0xFF1faee9),
//            Color(0xFF48d1cc),
//            Color(0xFF99ff99),
//            Color(0xFFfde910),
//        ),