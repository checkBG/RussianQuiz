package com.example.russianquiz.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.russianquiz.model.MainViewModel
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
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    db.execSQL("INSERT INTO user_settings (id, language_index) VALUES (1, 0)")
                }
            })
            .build()
        dao.dao
    }

    viewModel {
        MainViewModel(get())
    }
}