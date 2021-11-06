package com.viksaa.resources.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.viksaa.resources.app.R
import com.viksaa.resources.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        binding.run {
            val navController = findNavController(R.id.nav_host_fragment)
            setupActionBarWithNavController(
                navController, AppBarConfiguration(
                    setOf(
                        R.id.navigation_text, R.id.navigation_other, R.id.navigation_media
                    )
                )
            )
            navView.setupWithNavController(navController)
        }
    }
}