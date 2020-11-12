package com.viksaa.resources.app.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.viksaa.resources.app.R

class SplashScreenActivity : AppCompatActivity() {

    companion object {
        const val DELAY = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        animateText()
    }

    private fun animateText(){

        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.animator.fade_in)
        fadeInAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                navigateToMainActivity()
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        val titleText = findViewById<AppCompatTextView>(R.id.text_title)
        titleText.animation = fadeInAnimation

    }

    private fun navigateToMainActivity(){
        //wait for DELAY time before you navigate to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()}, DELAY)

    }
}