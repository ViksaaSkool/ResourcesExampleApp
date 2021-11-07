package com.viksaa.resources.app.ui.text

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.viksaa.resources.app.Constants.EN
import com.viksaa.resources.app.Constants.MK
import com.viksaa.resources.app.databinding.FragmentTextBinding
import com.viksaa.resources.app.ui.text.adapter.FontsRecyclerViewAdapter
import java.util.*

class TextFragment : Fragment() {

    private lateinit var fontsAdapter: FontsRecyclerViewAdapter

    private lateinit var binding: FragmentTextBinding
    private val textViewModel: TextViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTextBinding.inflate(inflater, container, false)
        setFontsList()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        invalidateLanguageIndicator()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setFontsList() {
        fontsAdapter = FontsRecyclerViewAdapter()
        binding.fontsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext().applicationContext)
            itemAnimator = DefaultItemAnimator()
            adapter = fontsAdapter
        }
        fontsAdapter.notifyDataSetChanged()
    }

    private fun invalidateLanguageIndicator() {
        binding.apply {
            mkText.isSelected = Locale.getDefault().language == MK
            enText.isSelected = Locale.getDefault().language == EN
        }
    }
}