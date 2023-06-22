package com.example.jcomposerickandmorty

import android.app.Application
import com.example.jcomposerickandmorty.di.appModule
import com.example.jcomposerickandmorty.di.dataModule
import com.example.jcomposerickandmorty.di.domainModule
import com.example.jcomposerickandmorty.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule,networkModule, dataModule, domainModule)
        }
    }
}