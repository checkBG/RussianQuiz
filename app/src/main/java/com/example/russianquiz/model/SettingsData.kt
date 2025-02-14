package com.example.russianquiz.model

data class SettingsData(
    val language: Language = Language.ENGLISH,
    val profile: Profile = Profile()
)
