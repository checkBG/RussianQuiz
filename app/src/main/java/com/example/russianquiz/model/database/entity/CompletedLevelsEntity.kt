package com.example.russianquiz.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completed_levels")
data class CompletedLevelsEntity(
    @PrimaryKey val id: Int = 0, // an index of a level
    val completed: Int = 0, // a count of completed levels
)
