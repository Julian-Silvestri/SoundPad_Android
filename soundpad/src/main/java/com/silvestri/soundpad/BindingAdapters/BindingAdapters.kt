package com.silvestri.soundpad.BindingAdapters

import android.content.res.ColorStateList
import android.view.View
import androidx.databinding.BindingAdapter

//TODO: Not sure if I need the binding adapter. Will need to do my own tests.

@BindingAdapter("backgroundTint")
fun setBackgroundTint(view: View, color: Int?) {
    if (color != null) {
        view.backgroundTintList = ColorStateList.valueOf(color)
    }
}
