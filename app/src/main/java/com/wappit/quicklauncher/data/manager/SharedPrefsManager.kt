package com.wappit.quicklauncher.data.manager

import android.content.Context
import android.content.SharedPreferences
import com.wappit.quicklauncher.data.model.AppState
import com.wappit.quicklauncher.data.model.ButtonPosition

private const val SAVED_URL_KEY = "SAVED_URL_KEY"
private const val SETTINGS_BUTTON_OPACITY_KEY = "SETTINGS_BUTTON_OPACITY_KEY"
private const val SETTINGS_BUTTON_X_POS_KEY = "SETTINGS_BUTTON_X_POS_KEY"
private const val SETTINGS_BUTTON_Y_POS_KEY = "SETTINGS_BUTTON_Y_POS_KEY"
private const val SETTINGS_BUTTON_SIZE_KEY = "SETTINGS_BUTTON_SIZE_KEY"
private const val SETTINGS_BUTTON_ICON_VISIBILITY_KEY = "SETTINGS_BUTTON_ICON_VISIBILITY_KEY"
private const val SETTINGS_BUTTON_TITLE_VISIBILITY_KEY = "SETTINGS_BUTTON_TITLE_VISIBILITY_KEY"

class SharedPrefsManager(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("QuickLauncher", 0) // 0 - for private mode
    private val editor: SharedPreferences.Editor = pref.edit()

    fun saveState(appState: AppState) {
        with(editor) {
            putString(SAVED_URL_KEY, appState.url)
            putFloat(SETTINGS_BUTTON_OPACITY_KEY, appState.settingsButtonOpacity ?: 100F)
            putInt(SETTINGS_BUTTON_X_POS_KEY, appState.settingsButtonXPosition?.pos ?: 0)
            putInt(SETTINGS_BUTTON_Y_POS_KEY, appState.settingsButtonYPosition?.pos ?: 100)
            putFloat(SETTINGS_BUTTON_SIZE_KEY, appState.settingsButtonSize ?: 2F)
            putBoolean(SETTINGS_BUTTON_ICON_VISIBILITY_KEY, appState.settingsButtonIconVisibility ?: false)
            putBoolean(SETTINGS_BUTTON_TITLE_VISIBILITY_KEY, appState.settingsButtonIconVisibility ?: true)
            commit()
        }
    }

    fun retrieveAppState(): AppState {
        return AppState(
            pref.getString(SAVED_URL_KEY, null),
            pref.getFloat(SETTINGS_BUTTON_OPACITY_KEY, 100F),
            ButtonPosition.from(pref.getInt(SETTINGS_BUTTON_X_POS_KEY, 0)),
            ButtonPosition.from(pref.getInt(SETTINGS_BUTTON_Y_POS_KEY, 100)),
            pref.getFloat(SETTINGS_BUTTON_SIZE_KEY, 2F),
            pref.getBoolean(SETTINGS_BUTTON_ICON_VISIBILITY_KEY, false),
            pref.getBoolean(SETTINGS_BUTTON_TITLE_VISIBILITY_KEY, true)
        )
    }
}