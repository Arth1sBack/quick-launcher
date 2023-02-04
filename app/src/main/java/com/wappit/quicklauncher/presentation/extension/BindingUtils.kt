package com.wappit.quicklauncher.presentation.extension

import android.widget.EditText
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.slider.Slider


@InverseBindingAdapter(attribute = "android:value")
fun getSliderValue(slider: Slider) = slider.value

@BindingAdapter("android:valueAttrChanged")
fun setSliderListeners(slider: Slider, attrChange: InverseBindingListener) {
    slider.addOnChangeListener { _, _, _ ->
        attrChange.onChange()
    }
}
@BindingAdapter("stringRes")
fun setStringRes(view: EditText, @StringRes resource: Int) {
    if (resource != 0) {
        view.setText(view.context.getString(resource))
    }
}