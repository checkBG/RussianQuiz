package com.example.russianquiz.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.database.SettingsDataDB
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 1 to 2")
        db.execSQL("ALTER TABLE user_settings ADD COLUMN solved_questions INTEGER NOT NULL DEFAULT 0")
        db.execSQL("ALTER TABLE user_settings ADD COLUMN right_answers INTEGER NOT NULL DEFAULT 0")

        db.execSQL("INSERT OR IGNORE INTO user_settings (id) VALUES (1)")
        Log.d("Migration", "Migration applied successfully.")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 2 to 3")
        db.execSQL("INSERT OR IGNORE INTO user_settings (id) VALUES (1)")
        Log.d("Migration", "Migration applied successfully.")
    }
}

val appModule = module {
    single {
        val dao = Room.databaseBuilder(
            get<Context>(),
            SettingsDataDB::class.java,
            name = "settings.db"
        )
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL("INSERT INTO user_settings (id) VALUES (1)")
                }
            })
            .build()
        dao.dao
    }

    viewModel {
        MainViewModel(get())
    }
}