package com.viksaa.resources.app.ui.media

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viksaa.resources.app.R

class MediaFragment : Fragment() {

    private lateinit var mediaViewModel: MediaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaViewModel =
            ViewModelProvider(this).get(MediaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_media, container, false)
        val textView = root.findViewById<AppCompatTextView>(R.id.text_notifications)
        mediaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }



    /*fun setAppearanceTheme(theme: Int) {
        when (theme) {
            AppAppearance.LIGHT -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            AppAppearance.DARK -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            AppAppearance.FOLLOW_SYSTEM -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }*/
}