package com.wappit.quicklauncher.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.presentation.model.AppState

class MainViewModel(
    private val sharedPrefsManager: SharedPrefsManager
) : ViewModel() {
    var appState = MutableLiveData<AppState>()

    init {
        appState.value = AppState(
            sharedPrefsManager.retrieveSavedUrl(),
            sharedPrefsManager.retrieveSavedButtonOpacity()
        )
    }

    fun saveData() {
        sharedPrefsManager.saveUrl(appState.value?.url)
        sharedPrefsManager.saveButtonOpacity(appState.value?.settingsButtonOpacity)
    }
}