package com.example.russianquiz.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.russianquiz.model.MainViewModel
import com.example.russianquiz.model.database.MIGRATION_1_2
import com.example.russianquiz.model.database.MIGRATION_2_3
import com.example.russianquiz.model.database.MIGRATION_3_4
import com.example.russianquiz.model.database.MIGRATION_4_5
import com.example.russianquiz.model.database.MIGRATION_5_6
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
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6)
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