package com.github.leventarican.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.leventarican.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // without view binding
//         setContentView(R.layout.activity_main)

        // with view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHelloworld.text = getString(R.string.app_name)
    }
}