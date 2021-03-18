package com.github.leventarican.underconstruction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.leventarican.underconstruction.databinding.ActivityMainBinding

/**
 * TODO: back button does not work. reset data to 0. if not it will navigate always to screen 1
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }
}
