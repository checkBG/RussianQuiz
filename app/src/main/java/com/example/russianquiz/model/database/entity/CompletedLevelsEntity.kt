package com.example.russianquiz.model.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "completed_level",
    foreignKeys = [
        ForeignKey(
            entity = SettingsDataEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ]
)
data class CompletedLevelsEntity(
    @PrimaryKey val id: Int = 0, // an index of a level
    @ColumnInfo(name = "user_id") val userId: Int = 1, // always is one
    val completed: Int = 0, // a count of completed levels
)
