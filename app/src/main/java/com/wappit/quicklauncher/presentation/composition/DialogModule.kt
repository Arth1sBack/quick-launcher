package com.wappit.quicklauncher.presentation.composition

import android.app.AlertDialog
import android.content.Context

class DialogModule(
    private val context: Context
) {
    fun displayDialogWithItemsAction(
        title: String,
        items: List<String>,
        callback: (Int) -> Unit,
        cancelCallback: (() -> Unit)? = null
    ) {
        val builder = AlertDialog.Builder(context)

        with(builder) {
            setTitle(title)
            setItems(items.toTypedArray()) { _, which ->
                callback(which)
            }
            setCancelable(true)
            setOnCancelListener {
                if (cancelCallback != null) {
                    cancelCallback()
                }
            }
        }
        val dialog = builder.create()

        dialog.show()
    }
}