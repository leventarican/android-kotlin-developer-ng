package com.github.leventarican.applayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect layout file with activity
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener { process(it) }
    }

    private fun process(view: View?) {
        val e = findViewById<EditText>(R.id.edit)
        val tv = findViewById<TextView>(R.id.textView)

        tv.text = e.text

        hideKeyboard(view)
    }
    
    private fun hideKeyboard(view: View?) {
        val keyboard =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.hideSoftInputFromWindow(view!!.windowToken, 0)
    }
}