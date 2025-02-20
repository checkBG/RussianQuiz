package com.example.russianquiz.model.database.dao

import com.example.russianquiz.model.database.entity.CompletedLevelsEntity
import com.example.russianquiz.model.database.entity.SettingsDataEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockSettingsDataDao : SettingsDataDao {
    override suspend fun updateQuizCount(userId: Int, quizCount: Int) {  }

    override suspend fun saveCompletedLevels(index: Int) {  }

    override fun getCompletedLevels(): Flow<List<CompletedLevelsEntity>> {
        return flow {
            listOf(
                CompletedLevelsEntity(id = 0),
                CompletedLevelsEntity(id = 1),
                CompletedLevelsEntity(id = 2),
                CompletedLevelsEntity(id = 3),
                CompletedLevelsEntity(id = 4),
                CompletedLevelsEntity(id = 5),
                CompletedLevelsEntity(id = 6),
                CompletedLevelsEntity(id = 7),
                CompletedLevelsEntity(id = 8),
                CompletedLevelsEntity(id = 9),
            )
        }
    }

    override suspend fun updateChosenAvatar(userId: Int, avatar: ByteArray?) {  }

    override suspend fun saveSettings(settings: SettingsDataEntity) {  }

    override suspend fun updateRightAnswers(userId: Int) {  }

    override suspend fun updateSolvedQuestions(userId: Int) {  }

    override suspend fun saveSelectedLanguage(languageIndex: Int) {  }

    override fun getSettings(userId: Int): Flow<SettingsDB> {
        return flow {
            SettingsDB(
                settings = SettingsDataEntity(),
                completedLevels = listOf(
                    CompletedLevelsEntity(id = 0),
                    CompletedLevelsEntity(id = 1),
                    CompletedLevelsEntity(id = 2),
                    CompletedLevelsEntity(id = 3),
                    CompletedLevelsEntity(id = 4),
                    CompletedLevelsEntity(id = 5),
                    CompletedLevelsEntity(id = 6),
                    CompletedLevelsEntity(id = 7),
                    CompletedLevelsEntity(id = 8),
                    CompletedLevelsEntity(id = 9),
                )
            )
        }
    }
}