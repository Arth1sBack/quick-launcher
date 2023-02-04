package com.wappit.quicklauncher.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.data.model.AppState

class MainViewModel(
    private val sharedPrefsManager: SharedPrefsManager
) : ViewModel() {
    var appState = MutableLiveData<AppState>()

    init {
        appState.value = sharedPrefsManager.retrieveAppState()
    }

    fun saveData() {
        appState.value?.let {
            sharedPrefsManager.saveState(it)
        }
    }
}