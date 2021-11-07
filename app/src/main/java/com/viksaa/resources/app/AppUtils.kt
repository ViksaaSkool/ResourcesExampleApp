package com.viksaa.resources.app

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat


object Constants {
    val FONTS_LIST =
        listOf(R.font.great_vibes_font, R.font.howkins_free_font, R.font.stay_happy_font)
    const val MK = "mk"
    const val EN = "en"
}

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager =
            ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

@SuppressLint("ClickableViewAccessibility")
fun View.hideKeyboardOnFocusLoss() {
    if (this !is EditText) {
        setOnTouchListener { _, _ ->
            (context as Activity).hideSoftKeyboard()
            false
        }
    }
    if (this is ViewGroup) {
        for (i in 0 until this.childCount) {
            val innerView = this.getChildAt(i)
            innerView.hideKeyboardOnFocusLoss()
        }
    }
}