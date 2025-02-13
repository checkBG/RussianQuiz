package com.example.russianquiz.model.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.russianquiz.model.database.entity.SettingsDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDataDao {
    @Upsert
    suspend fun saveSettings(settings: SettingsDataEntity)

    @Query("UPDATE user_settings SET right_answers = right_answers + 1 WHERE id = 1")
    suspend fun updateRightAnswers()

    @Query("UPDATE user_settings SET solved_questions = solved_questions + 1 WHERE id = 1")
    suspend fun updateSolvedQuestions()

    @Query("UPDATE user_settings SET language_index = :languageIndex WHERE id = 1")
    suspend fun saveSelectedLanguage(languageIndex: Int)

    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    fun getSettings(): Flow<SettingsDataEntity?>
}