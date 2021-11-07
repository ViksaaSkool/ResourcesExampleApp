package com.viksaa.resources.app.ui.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.viksaa.resources.app.R
import com.viksaa.resources.app.components.UserCard
import com.viksaa.resources.app.databinding.FragmentOtherBinding
import com.viksaa.resources.app.hideKeyboardOnFocusLoss
import java.util.*

class OtherFragment : Fragment() {

    private lateinit var binding: FragmentOtherBinding
    private val otherViewModel: OtherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOtherBinding.inflate(inflater, container, false)
        binding.viewModel = otherViewModel
        binding.root.hideKeyboardOnFocusLoss()
        initComposableView()
        setButton()
        return binding.root
    }

    private fun setButton() {
        binding.exampleButton.run {
            val messages = requireContext().resources.getStringArray(R.array.button_messages_text)
            setOnClickListener {
                val number = Random().nextInt(messages.size - 1)
                val message = String.format(
                    requireContext().getString(R.string.toast_text),
                    messages[number],
                    number
                )
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initComposableView() {
        binding.myComposable.setContent {
            MaterialTheme {
                UserCard()
            }
        }
    }
}