package com.wappit.quicklauncher.presentation.ui.settings

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.databinding.FragmentSettingsBinding
import com.wappit.quicklauncher.presentation.extension.hideKeyboard
import com.wappit.quicklauncher.presentation.extension.onDone
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by activityViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        KeyboardVisibilityEvent.setEventListener(requireActivity()) {
            if (!it) {
                binding.fragmentSettingsEdittextUrl.clearFocus()
            }
        }

        initViews()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.fragmentSettingsTextviewResolution.text = "Your current resolution is:\n\t- width : ${Resources.getSystem().displayMetrics.widthPixels}\n\t- height : ${Resources.getSystem().displayMetrics.heightPixels}"
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.saveData()
    }

    private fun initViews() {
        binding.fragmentSettingsEdittextUrl.onDone {
            it.clearFocus()
            it.hideKeyboard()
        }
    }
}