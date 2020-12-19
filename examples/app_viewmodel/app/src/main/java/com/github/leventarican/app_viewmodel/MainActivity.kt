package com.github.leventarican.app_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/**
 * This is our UI controller.
 * Which should be connected to the ViewModel.
 */
class MainActivity : AppCompatActivity() {
    var value = 0;
    private lateinit var viewModel: ValueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ValueViewModel::class.java)
        display()
    }

    fun increase(v: View) {
        viewModel.value++
        display()
    }

    fun decrease(v: View) {
        viewModel.value--
        display()
    }

    private fun display() {
        val tv = findViewById<TextView>(R.id.textView)
        tv.text = viewModel.value.toString()
    }
}