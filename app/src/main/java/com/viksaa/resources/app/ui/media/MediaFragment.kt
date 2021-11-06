package com.viksaa.resources.app.ui.media

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.viksaa.resources.app.R
import com.viksaa.resources.app.databinding.FragmentMediaBinding


class MediaFragment : Fragment() {

    private val mediaViewModel: MediaViewModel by viewModels()
    private lateinit var binding: FragmentMediaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setSound()
        setVideo()
    }

    private fun setVideo() {
        val videoUri =
            Uri.parse("android.resource://${requireContext().packageName}/${R.raw.video_funny}")
        binding.apply {
            videoView.setMediaController(MediaController(requireContext()))
            videoView.setVideoURI(videoUri)
            videoPlay.setOnClickListener { videoView.start() }
            videoStop.setOnClickListener { videoView.pause() }
        }
    }

    private fun setSound() {
        val sound = MediaPlayer.create(requireContext(), R.raw.sound_whistle)
        binding.apply {
            soundPlay.setOnClickListener { sound.start() }
            soundStop.setOnClickListener { sound.pause() }
        }
    }


}