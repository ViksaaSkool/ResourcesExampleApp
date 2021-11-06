package com.viksaa.resources.app.ui.media

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
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
        setVideo(root)
        setSound(root)
        return root
    }

    private fun setVideo(view: View) {
        val videoView = view.findViewById<VideoView>(R.id.video_view)
        val video =
            Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.video_funny)

        videoView.setMediaController(MediaController(requireContext()))

        videoView.setVideoURI(video)
        val videoPlay = view.findViewById<AppCompatImageView>(R.id.video_play)
        videoPlay.setOnClickListener { videoView.start() }
        val videoStop = view.findViewById<AppCompatImageView>(R.id.video_stop)
        videoStop.setOnClickListener { videoView.pause() }

    }

    private fun setSound(view: View) {
        val sound = MediaPlayer.create(requireContext(), R.raw.sound_whistle)
        val soundPlay = view.findViewById<AppCompatImageView>(R.id.sound_play)
        soundPlay.setOnClickListener { sound.start() }
        val soundStop = view.findViewById<AppCompatImageView>(R.id.sound_stop)
        soundStop.setOnClickListener { sound.pause() }
    }


}