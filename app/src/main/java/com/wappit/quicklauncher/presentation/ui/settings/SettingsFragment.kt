package com.wappit.quicklauncher.presentation.ui.settings

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wappit.quicklauncher.R
import com.wappit.quicklauncher.data.model.ButtonPosition
import com.wappit.quicklauncher.databinding.FragmentSettingsBinding
import com.wappit.quicklauncher.presentation.composition.AppVersionModule
import com.wappit.quicklauncher.presentation.composition.DialogModule
import com.wappit.quicklauncher.presentation.extension.hideKeyboard
import com.wappit.quicklauncher.presentation.extension.onDone
import com.wappit.quicklauncher.presentation.viewmodel.MainViewModel
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.parameter.parametersOf

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by activityViewModel<MainViewModel>()
    private val dialogModule by inject<DialogModule> { parametersOf(requireActivity()) }
    private val appVersionModule by inject<AppVersionModule>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.prepareDraftState()

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

    private fun initViews() {
        binding.fragmentSettingsTextviewVersion.text = appVersionModule.appVersion()

        binding.fragmentSettingsEdittextUrl.onDone {
            it.clearFocus()
            it.hideKeyboard()
        }

        with(binding.fragmentSettingsEdittextButtonXPos) {
            isEnabled = true
            inputType = android.text.InputType.TYPE_NULL
            onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    view.hideKeyboard()

                    dialogModule.displayDialogWithItemsAction(
                        "Button X Pos",
                        ButtonPosition.values().map { getString(it.localizedHorizontal) },
                        {
                            val selectedPosition = ButtonPosition.values()[it]
                            setText(selectedPosition.localizedHorizontal)
                            viewModel.draftAppState.value?.settingsButtonXPosition = selectedPosition
                            clearFocus()
                        }, {
                            clearFocus()
                        }
                    )
                }
            }
        }

        with(binding.fragmentSettingsEdittextButtonYPos) {
            isEnabled = true
            inputType = android.text.InputType.TYPE_NULL
            onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
                if (hasFocus) {
                    view.hideKeyboard()

                    dialogModule.displayDialogWithItemsAction(
                        "Button Y Pos",
                        ButtonPosition.values().map { getString(it.localizedVertical) },
                        {
                            val selectedPosition = ButtonPosition.values()[it]
                            setText(selectedPosition.localizedVertical)
                            viewModel.draftAppState.value?.settingsButtonYPosition = selectedPosition
                            clearFocus()
                        }, {
                            clearFocus()
                        }
                    )
                }
            }
        }

        binding.fragmentSettingsSliderButtonSize.setLabelFormatter {
            when {
                it < 1 -> getString(R.string.settings_button_size_s)
                it < 2 -> getString(R.string.settings_button_size_m)
                else -> getString(R.string.settings_button_size_l)
            }
        }

        binding.fragmentSettingsButtonApply.setOnClickListener {
            viewModel.saveData()
            it.findNavController().popBackStack()
        }
        binding.fragmentSettingsButtonSupport.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.buyMeCoffeeUrl))
            requireActivity().startActivity(browserIntent)
        }
    }
}