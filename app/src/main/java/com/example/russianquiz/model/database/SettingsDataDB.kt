package com.example.russianquiz.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.russianquiz.model.database.dao.SettingsDataDao
import com.example.russianquiz.model.database.entity.CompletedLevelsEntity
import com.example.russianquiz.model.database.entity.SettingsDataEntity
import com.example.russianquiz.utils.BitmapConverter

@Database(
    entities = [SettingsDataEntity::class, CompletedLevelsEntity::class],
    version = 7,
)
@TypeConverters(BitmapConverter::class)
abstract class SettingsDataDB : RoomDatabase() {
    abstract val dao: SettingsDataDao
}