package com.wappit.quicklauncher.di

import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Manager
    single { SharedPrefsManager(androidContext()) }

    // ViewModel
    viewModel { MainViewModel(get()) }
}