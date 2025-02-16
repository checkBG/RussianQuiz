package com.example.russianquiz.model

import android.graphics.Bitmap
import com.example.russianquiz.model.database.entity.CompletedLevelsEntity

data class Profile(
    val chosenPhotoProfile: Bitmap? = null,
    val solvedQuestions: Int = 0,
    val rightAnswers: Int = 0,
    val completedLevels: List<CompletedLevelsEntity> = emptyList()
)