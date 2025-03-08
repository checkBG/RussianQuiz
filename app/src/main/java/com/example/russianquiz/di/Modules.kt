package com.example.russianquiz.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.russianquiz.model.Level
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.database.MIGRATION_1_2
import com.example.russianquiz.model.database.MIGRATION_2_3
import com.example.russianquiz.model.database.MIGRATION_3_4
import com.example.russianquiz.model.database.MIGRATION_4_5
import com.example.russianquiz.model.database.MIGRATION_5_6
import com.example.russianquiz.model.database.MIGRATION_6_7
import com.example.russianquiz.model.database.SettingsDataDB
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        val dao = Room.databaseBuilder(
            get<Context>(),
            SettingsDataDB::class.java,
            name = "settings.db"
        )
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL(
                        """
                        CREATE TABLE IF NOT EXISTS user_settings (
                            id INTEGER PRIMARY KEY NOT NULL,
                            language_index INTEGER NOT NULL DEFAULT 0,
                            quiz_count INTEGER NOT NULL DEFAULT 10,
                            solved_questions INTEGER NOT NULL DEFAULT 0,
                            right_answers INTEGER NOT NULL DEFAULT 0,
                            avatar BLOB
                        )
                    """.trimIndent()
                    )

                    db.execSQL("INSERT INTO user_settings (id, language_index, quiz_count, solved_questions, right_answers) VALUES (1, 0, 10, 0, 0)")

                    db.execSQL(
                        """
                        CREATE TABLE IF NOT EXISTS completed_level (
                            id INTEGER PRIMARY KEY NOT NULL,
                            user_id INTEGER NOT NULL DEFAULT 1,
                            completed INTEGER NOT NULL,
                            FOREIGN KEY(user_id) REFERENCES user_settings(id) ON DELETE CASCADE ON UPDATE CASCADE
                        )
                    """.trimIndent()
                    )

                    Level.entries.forEach {
                        db.execSQL("INSERT OR IGNORE INTO completed_level (id, completed, user_id) VALUES (${it.ordinal}, 0, 1)")
                    }
                }
            })
            .build()
        dao.dao
    }

    viewModel {
        MainViewModel(get())
    }
}