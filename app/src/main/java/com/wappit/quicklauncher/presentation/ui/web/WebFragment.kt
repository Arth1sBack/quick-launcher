package com.wappit.quicklauncher.presentation.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.lifecycleOwner = viewLifecycleOwner

        initView()

        return binding.root
    }

    private fun initView() {
        binding.fragmentWebButtonSettings.setOnClickListener {
            val action = WebFragmentDirections.actionWebFragmentToSettingsFragment()
            it.findNavController().navigate(action)
        }
    }
}