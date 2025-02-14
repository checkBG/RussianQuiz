package com.example.russianquiz.model

import android.graphics.Bitmap

data class Profile(
    val chosenPhotoProfile: Bitmap? = null,
    val solvedQuestions: Int = 0,
    val rightAnswers: Int = 0,
    val completedLevels: MutableMap<Level, Int> = Level.entries
        .associateWith { 0 }
        .toMutableMap(),
) {
    fun completedLevel(level: Level) {
        completedLevels[level] = completedLevels[level]?.plus(1) ?: 0
    }
}