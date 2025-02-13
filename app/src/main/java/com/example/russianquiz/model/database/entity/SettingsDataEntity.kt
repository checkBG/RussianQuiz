package com.example.russianquiz.model.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class SettingsDataEntity(
    @PrimaryKey val id: Int = 1, // there is only one possible id
    @ColumnInfo(name = "language_index") val languageIndex: Int = 0, // 0 is English by default
    @ColumnInfo(name = "solved_questions") val solvedQuestions: Int = 0, // 0 is a default value
    @ColumnInfo(name = "right_answers") val rightAnswers: Int = 0, // 0 is a default value
)