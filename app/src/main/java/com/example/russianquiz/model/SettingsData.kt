package com.example.russianquiz.model

data class SettingsData(
    val language: Languages = Languages.ENGLISH,
    val profile: Profile = Profile()
)
