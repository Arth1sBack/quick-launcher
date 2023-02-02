package com.wappit.quicklauncher.data.manager

import android.content.Context
import android.content.SharedPreferences

private const val SAVED_URL_KEY = "SAVED_URL_KEY"

class SharedPrefsManager(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("QuickLauncher", 0) // 0 - for private mode
    private val editor: SharedPreferences.Editor = pref.edit()

    fun saveUrl(url: String?) {
        with(editor) {
            putString(SAVED_URL_KEY, url)
            commit()
        }
    }

    fun retrieveSavedUrl(): String? {
        return pref.getString(SAVED_URL_KEY, null)
    }
}