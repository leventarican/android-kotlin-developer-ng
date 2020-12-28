package com.github.leventarican.applayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.github.leventarican.applayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ActivityMainBinding name is derived from the layout file: activity_main
    private lateinit var binding: ActivityMainBinding

    // bind the data
    private val programmingLang: Data = Data(name = "java / kotlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // assign data to layout
        binding.programmingLang = programmingLang

        binding.button.setOnClickListener { process(it) }
    }

    private fun process(view: View?) {
        binding.textView.text = binding.edit.text
        hideKeyboard(view)
    }

    private fun hideKeyboard(view: View?) {
        val keyboard =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.hideSoftInputFromWindow(view!!.windowToken, 0)
    }
}