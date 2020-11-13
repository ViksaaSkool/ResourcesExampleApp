package com.viksaa.resources.app.ui.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.viksaa.resources.app.Constants.MK
import com.viksaa.resources.app.R
import com.viksaa.resources.app.ui.text.adapter.FontsRecyclerViewAdapter
import java.util.*

class TextFragment : Fragment() {

    private lateinit var fontsAdapter: FontsRecyclerViewAdapter
    private lateinit var textViewModel: TextViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        textViewModel =
            ViewModelProvider(this).get(TextViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_text, container, false)
        setFontsList(root)
        setLanguageIndicator(root)
        return root
    }

    private fun setFontsList(view: View){
        fontsAdapter = FontsRecyclerViewAdapter()
        val fontsRecyclerView = view.findViewById<RecyclerView>(R.id.fonts_recycler_view)
        val layoutManager = LinearLayoutManager(requireContext().applicationContext)
        fontsRecyclerView.layoutManager = layoutManager
        fontsRecyclerView.itemAnimator = DefaultItemAnimator()
        fontsRecyclerView.adapter = fontsAdapter
        fontsAdapter.notifyDataSetChanged()
    }

    private fun setLanguageIndicator(view: View){
        val enText = view.findViewById<AppCompatTextView>(R.id.en_text)
        val mkText = view.findViewById<AppCompatTextView>(R.id.mk_text)
        if(Locale.getDefault().language == MK){
            mkText.isSelected = true
            enText.isSelected = false
        }else{
            mkText.isSelected = false
            enText.isSelected = true
        }
    }
}