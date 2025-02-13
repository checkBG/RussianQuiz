package com.example.russianquiz.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DaoApplication : Application(){
    override fun onCreate() {
        startKoin {
            androidContext(this@DaoApplication)
            modules(appModule)
        }
        super.onCreate()
    }
}