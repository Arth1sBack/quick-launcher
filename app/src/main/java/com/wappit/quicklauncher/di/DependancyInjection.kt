package com.wappit.quicklauncher.di

import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { SharedPrefsManager(androidContext()) }
}