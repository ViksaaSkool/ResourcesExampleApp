package com.viksaa.resources.app.ui.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viksaa.resources.app.R
import java.util.*

class OtherFragment : Fragment() {

    private lateinit var otherViewModel: OtherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        otherViewModel =
            ViewModelProvider(this).get(OtherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_other, container, false)
        setButton(root)
        setThemeChanger(root)
        return root
    }


    private fun setButton(view: View){
        val button = view.findViewById<AppCompatButton>(R.id.example_button)
        val messages = requireContext().resources.getStringArray(R.array.button_messages_text)
        button.setOnClickListener {
            val number = Random().nextInt(messages.size-1)
            val message = String.format(requireContext().getString(R.string.toast_text), messages[number], number)
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setThemeChanger(view: View){
        val themeSwitch = view.findViewById<AppCompatToggleButton>(R.id.theme_switch)
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
}