package com.wappit.quicklauncher.data.model

import androidx.annotation.StringRes
import com.wappit.quicklauncher.R

enum class ButtonPosition(
    val pos: Int
) {
    START(0),
    MIDDLE(50),
    END(100);

    companion object {
        private val map = ButtonPosition.values().associateBy { it.pos }
        infix fun from(value: Int) = map[value]
    }

    val localizedHorizontal: Int
        get() {
            return when(this) {
                START -> R.string.settings_button_pos_x_0
                MIDDLE -> R.string.settings_button_pos_x_50
                END -> R.string.settings_button_pos_x_100
            }
        }

    val localizedVertical: Int
        get() {
            return when(this) {
                START -> R.string.settings_button_pos_y_0
                MIDDLE -> R.string.settings_button_pos_y_50
                END -> R.string.settings_button_pos_y_100
            }
        }
}