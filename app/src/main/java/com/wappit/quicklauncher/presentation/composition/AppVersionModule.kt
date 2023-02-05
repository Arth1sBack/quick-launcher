package com.wappit.quicklauncher.presentation.composition

import com.wappit.quicklauncher.BuildConfig

class AppVersionModule {
    fun appVersion(): String {
        val versionCode: Int = BuildConfig.VERSION_CODE
        val versionName: String = BuildConfig.VERSION_NAME
        return "$versionName-(build $versionCode)"
    }
}