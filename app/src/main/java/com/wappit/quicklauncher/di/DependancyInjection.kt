package com.wappit.quicklauncher.di

import android.content.Context
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.presentation.composition.DialogModule
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Manager
    single { SharedPrefsManager(androidContext()) }

    // Module
    single { (context: Context) -> DialogModule(context) }

    // ViewModel
    viewModel { MainViewModel(get()) }
}