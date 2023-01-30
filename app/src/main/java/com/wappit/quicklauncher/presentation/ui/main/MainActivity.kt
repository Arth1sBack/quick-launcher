package com.wappit.quicklauncher.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.presentation.QuickLaunchApplication
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val sharedPrefsManager: SharedPrefsManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        
    }
}