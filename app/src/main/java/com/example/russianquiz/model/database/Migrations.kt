package com.example.russianquiz.model.database

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.russianquiz.model.Level

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 1 to 2")
        db.execSQL("ALTER TABLE user_settings ADD COLUMN solved_questions INTEGER NOT NULL DEFAULT 0")
        db.execSQL("ALTER TABLE user_settings ADD COLUMN right_answers INTEGER NOT NULL DEFAULT 0")

        db.execSQL("INSERT OR IGNORE INTO user_settings (id, language_index, quiz_count, solved_questions, right_answers) VALUES (1, 0, 10, 0, 0)")
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

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 3 to 4")
        db.execSQL(
            """CREATE TABLE IF NOT EXISTS completed_level (
            |    id INTEGER PRIMARY KEY NOT NULL,
            |    completed INTEGER NOT NULL
            |)""".trimMargin()
        )

        Level.entries.forEach {
            db.execSQL("INSERT INTO completed_level (id, completed) VALUES (${it.ordinal}, 0)")
        }
        Log.d("Migration", "Migration applied successfully.")
    }
}

val MIGRATION_4_5 = object : Migration(4, 5) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 4 to 5")
        db.execSQL("ALTER TABLE completed_level ADD COLUMN user_id INTEGER NOT NULL DEFAULT 1;")

        // Create a new temporary table which will be main
        db.execSQL("""
            CREATE TABLE completed_level_tmp (
                id INTEGER PRIMARY KEY NOT NULL,
                user_id INTEGER NOT NULL,
                completed INTEGER NOT NULL,
                FOREIGN KEY(user_id) REFERENCES user_settings(id) ON DELETE CASCADE ON UPDATE CASCADE
            )
        """)

        // Copy the data from the old table into the new one
        db.execSQL("""
            INSERT INTO completed_level_tmp (id, user_id, completed)
            SELECT id, user_id, completed FROM completed_level;
        """)

        // Delete the old table
        db.execSQL("DROP TABLE completed_level;")

        // Make a new temporary table into main using old name
        db.execSQL("ALTER TABLE completed_level_tmp RENAME TO completed_level;")

        Log.d("Migration", "Migration applied successfully.")
    }
}

val MIGRATION_5_6 = object : Migration(5, 6) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 5 to 6")
        db.execSQL("ALTER TABLE user_settings ADD COLUMN avatar BLOB")

        Log.d("Migration", "Migration applied successfully.")
    }
}

val MIGRATION_6_7 = object : Migration(6, 7) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("Migration", "Applying migration from version 6 to 7")

        db.execSQL("ALTER TABLE user_settings ADD COLUMN quiz_count INTEGER NOT NULL DEFAULT 10")

        Log.d("Migration", "Migration applied successfully.")
    }
}