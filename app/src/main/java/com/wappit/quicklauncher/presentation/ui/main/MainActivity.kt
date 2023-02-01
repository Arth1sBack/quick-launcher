package com.wappit.quicklauncher.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.data.manager.SharedPrefsManager
import com.wappit.quicklauncher.databinding.ActivityMainBinding
import com.wappit.quicklauncher.presentation.QuickLaunchApplication
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.activity_main_container_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}