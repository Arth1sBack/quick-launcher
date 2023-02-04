package com.wappit.quicklauncher.presentation.extension

import android.view.View
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
@BindingAdapter("app:width")
fun setWidth(view: View, size: Float) {
    val params = view.layoutParams
    params.width = size.toInt()
    view.layoutParams = params
}

@BindingAdapter("app:height")
fun setHeight(view: View, size: Float) {
    val params = view.layoutParams
    params.height = size.toInt()
    view.layoutParams = params
}