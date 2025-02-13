package com.example.russianquiz.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.russianquiz.model.database.dao.SettingsDataDao
import com.example.russianquiz.model.database.entity.SettingsDataEntity

@Database(
    entities = [SettingsDataEntity::class],
    version = 1,
)
abstract class SettingsDataDB : RoomDatabase() {
    abstract val dao: SettingsDataDao
}