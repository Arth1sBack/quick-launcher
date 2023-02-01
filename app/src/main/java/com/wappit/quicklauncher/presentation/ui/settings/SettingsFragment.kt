package com.wappit.quicklauncher.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.databinding.FragmentSettingsBinding
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by activityViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}