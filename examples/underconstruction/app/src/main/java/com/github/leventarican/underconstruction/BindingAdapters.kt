package com.github.leventarican.underconstruction

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * you need the kotlin-kapt plugin for this.
 */
object BindingAdapters {

    @BindingAdapter("code")
    @JvmStatic
    fun code(view: TextView, display: Boolean) {
        view.apply {
            this.text = if (display) {
                "binding adapters works."
            } else {
                "access denied."
            }
            this.textSize = 8F
        }
    }
}