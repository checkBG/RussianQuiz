package com.example.russianquiz.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.russianquiz.R

enum class Century(
    val centuryNumber: Int,
    val yearRange: Int,
    @StringRes val century: Int,
    var isFirstCompleted: Boolean = false,
    var isSecondCompleted: Boolean = false,
    var isThirdCompleted: Boolean = false,
    var maxScore: Int = 0,
    val colors: List<Color>
) {
    NINTH(
        centuryNumber = 9,
        yearRange = 801,
        century = R.string.ninth,
        colors = listOf(
            Color(0xFF6600ff),
            Color(0xFF6600ff),
            Color(0xFF138808),
            Color(0xFFfde910),
        ),
    ),
    TENTH(
        centuryNumber = 10,
        yearRange = 901,
        century = R.string.tenth,
        colors = listOf(
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
            Color(0xFFea8df7),
            Color(0xFFea8df7),
        ),
    ),
    ELEVENTH(
        centuryNumber = 11,
        yearRange = 1001,
        century = R.string.eleventh,
        colors = listOf(
            Color(0xFFea8df7),
            Color(0xFFea8df7),
            Color(0xFFff9966),
            Color(0xFFffb6c1),
            Color(0xFFff8800),
        ),
    ),
    TWELFTH(
        centuryNumber = 12,
        yearRange = 1101,
        century = R.string.twelfth,
        colors = listOf(
            Color(0xFF00008b),
            Color(0xFFc154c1),
        ),
    ),
    THIRTEENTH(
        centuryNumber = 13,
        yearRange = 1201,
        century = R.string.thirteenth,
        colors = listOf(
            Color(0xFF996666),
            Color(0xFF996666),
            Color(0xFFffdc33),
            Color(0xFFefd334),
        ),
    ),
    FOURTEENTH(
        centuryNumber = 14,
        yearRange = 1301,
        century = R.string.fourteenth,
        colors = listOf(
            Color(0xFF966a57),
            Color(0xFFcd7f32),
            Color(0xFFc0c0c0),
            Color(0xFFb0b7c6),
        ),
    ),
    FIFTEENTH(
        centuryNumber = 15,
        yearRange = 1401,
        century = R.string.fifteenth,
        colors = listOf(
            Color(0xFF8B4513),
            Color(0xFFFF4D00),
            Color(0xFFF8F32B),
        ),
    ),
    SIXTEENTH(
        centuryNumber = 16,
        yearRange = 1501,
        century = R.string.sixteenth,
        colors = listOf(
            Color(0xFF98fB98),
            Color(0xFFffC0CB),
            Color(0xFFFEFE22),
        ),
    ),
    SEVENTEENTH(
        centuryNumber = 17,
        yearRange = 1601,
        century = R.string.seventeenth,
        colors = listOf(
            Color(0xFF00FFFF),
            Color(0xFFFDE910),
        ),
    ),
    EIGHTEENTH(
        centuryNumber = 18,
        yearRange = 1701,
        century = R.string.eighteenth,
        colors = listOf(
            Color(0xFF95500c),
            Color(0xFFff2400),
            Color(0xAA98ff98),
            Color(0xFF98ff98),
        ),
    ),
    NINETEENTH(
        centuryNumber = 19,
        yearRange = 1801,
        century = R.string.nineteenth,
        colors = listOf(
            Color(0xFF1faee9),
            Color(0xFF48d1cc),
            Color(0xFF99ff99),
            Color(0xFFfde910),
        ),
    ),
    TWENTIETH(
        centuryNumber = 20,
        yearRange = 1901,
        century = R.string.twentieth,
        colors = listOf(
            Color(0xFF7D1497),
            Color(0xFF7D1497),
            Color(0xFFFF6347),
            Color(0xFFC8A2C8),
            Color(0xFFFFC0CB),
        ),
    ),
    TWENTY_FIRST(
        centuryNumber = 21,
        yearRange = 2001,
        century = R.string.twenty_first,
        colors = listOf(
            Color(0xFF99FF00),
            Color(0xFFFF0099)
        ),
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