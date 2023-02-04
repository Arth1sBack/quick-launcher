package com.wappit.quicklauncher.data.model

data class AppState(
    var url: String?,
    var settingsButtonOpacity: Float?,
    var settingsButtonXPosition: ButtonPosition?,
    var settingsButtonYPosition: ButtonPosition?,
    var settingsButtonSize: Float?,
    var settingsButtonIconVisibility: Boolean?,
    var settingsButtonTitleVisibility: Boolean?
)