package com.example.russianquiz.model.database.dao

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.russianquiz.model.database.entity.CompletedLevelsEntity
import com.example.russianquiz.model.database.entity.SettingsDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SettingsDataDao {
    // completed_level
    @Query("UPDATE completed_level SET completed = completed + 1 WHERE id = :index")
    suspend fun saveCompletedLevels(index: Int)

    @Query("SELECT * FROM completed_level")
    fun getCompletedLevels(): Flow<List<CompletedLevelsEntity>>

    // user_settings
    @Query("UPDATE user_settings SET quiz_count = :quizCount WHERE id = :userId")
    suspend fun updateQuizCount(userId: Int = 1, quizCount: Int)

    @Query("UPDATE user_settings SET avatar = :avatar WHERE id = :userId")
    suspend fun updateChosenAvatar(userId: Int = 1, avatar: ByteArray?)

    @Upsert
    suspend fun saveSettings(settings: SettingsDataEntity)

    @Query("UPDATE user_settings SET right_answers = right_answers + 1 WHERE id = :userId")
    suspend fun updateRightAnswers(userId: Int = 1)

    @Query("UPDATE user_settings SET solved_questions = solved_questions + 1 WHERE id = :userId")
    suspend fun updateSolvedQuestions(userId: Int = 1)

    @Query("UPDATE user_settings SET language_index = :languageIndex WHERE id = 1")
    suspend fun saveSelectedLanguage(languageIndex: Int)

    @Transaction
    @Query("SELECT * FROM user_settings WHERE id = :userId")
    fun getSettings(userId: Int = 1) : Flow<SettingsDB?>
}

data class SettingsDB(
    @Embedded val settings: SettingsDataEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_id",
    )
    val completedLevels: List<CompletedLevelsEntity>
)