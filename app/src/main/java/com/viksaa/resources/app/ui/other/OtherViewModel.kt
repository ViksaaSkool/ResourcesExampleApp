package com.viksaa.resources.app.ui.other

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel

class OtherViewModel : ViewModel() {

    fun setTheme(isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}