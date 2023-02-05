package com.wappit.quicklauncher.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.data.model.AppState

class MainViewModel(
    private val sharedPrefsManager: SharedPrefsManager
) : ViewModel() {
    val buyMeCoffeeUrl = "https://www.buymeacoffee.com/mimosa"

    var appState = MutableLiveData<AppState>()
    var draftAppState = MutableLiveData<AppState>()

    init {
        appState.value = sharedPrefsManager.retrieveAppState()
    }

    fun prepareDraftState() {
        draftAppState.value = appState.value?.copy()
    }

    fun saveData() {
        if (draftAppState.value?.url.isNullOrEmpty()) {
            draftAppState.value?.url = buyMeCoffeeUrl
        }
        appState.value = draftAppState.value?.copy()
        appState.value?.let {
            sharedPrefsManager.saveState(it)
        }
    }
}