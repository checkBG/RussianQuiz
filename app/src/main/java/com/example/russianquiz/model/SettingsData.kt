package com.example.russianquiz.model

import android.graphics.Bitmap

data class SettingsData(
    val language: Languages = Languages.ENGLISH,
    val chosenPhotoProfile: Bitmap? = null,
)
