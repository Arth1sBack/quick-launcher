package com.wappit.quicklauncher.presentation.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private lateinit var binding: FragmentWebBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_web, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}