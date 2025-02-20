package com.example.russianquiz.model

data class SettingsData(
    val language: Language = Language.ENGLISH,
    val quizCount: Int = 10,
    val profile: Profile = Profile(),
)
