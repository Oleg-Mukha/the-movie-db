package com.olegatron.themoviedb

import android.app.Application
import com.olegatron.data.di.movieDataModule
import com.olegatron.themoviedb.di.movieAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            modules(listOf(movieDataModule, movieAppModule))
        }
    }
}