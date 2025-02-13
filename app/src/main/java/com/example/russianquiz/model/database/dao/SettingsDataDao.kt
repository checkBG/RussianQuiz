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

    @Query("SELECT * FROM user_settings WHERE user_settings.id = 1 LIMIT 1")
    fun getSettings(): Flow<SettingsDataEntity?>
}