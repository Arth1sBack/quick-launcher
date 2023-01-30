package com.wappit.quicklauncher.presentation

import android.app.Application
import com.wappit.quicklauncher.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuickLaunchApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@QuickLaunchApplication)
            modules(appModule)
        }
    }
}