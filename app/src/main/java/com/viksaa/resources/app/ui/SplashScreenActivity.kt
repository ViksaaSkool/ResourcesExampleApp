package com.viksaa.resources.app.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.viksaa.resources.app.R
import com.viksaa.resources.app.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val DELAY = 1000L
    }

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animateText()
    }

    @SuppressLint("ResourceType")
    private fun animateText() {
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.animator.fade_in)
        fadeInAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                navigateToMainActivity()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        binding.textTitle.animation = fadeInAnimation
    }

    private fun navigateToMainActivity() {
        //wait for DELAY time before you navigate to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(intent)
                finishAffinity()
            }, DELAY
        )
    }


}