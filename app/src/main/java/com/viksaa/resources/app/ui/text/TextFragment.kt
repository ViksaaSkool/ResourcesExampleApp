package com.viksaa.resources.app.ui.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viksaa.resources.app.R

class TextFragment : Fragment() {

    private lateinit var textViewModel: TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        textViewModel =
            ViewModelProvider(this).get(TextViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_text, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        textViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}