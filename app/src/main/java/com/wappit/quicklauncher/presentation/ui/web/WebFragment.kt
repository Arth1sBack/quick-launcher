package com.wappit.quicklauncher.presentation.ui.web

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.databinding.FragmentWebBinding
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class WebFragment : Fragment() {
    private lateinit var binding: FragmentWebBinding
    private val viewModel by activityViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_web, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initViews()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupWebView()
    }

    private fun initViews() {
        binding.fragmentWebButtonSettings.setOnClickListener {
            navigateToSettingsView()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        viewModel.appState.value?.url?.let {
            with(binding.fragmentWebWebview) {
                this.settings.javaScriptEnabled = true
                this.loadUrl(it)
            }
            return
        }
        navigateToSettingsView()

    }
    private fun navigateToSettingsView() {
        val action = WebFragmentDirections.actionWebFragmentToSettingsFragment()
        binding.root.findNavController().navigate(action)
    }
}