package com.github.leventarican.applivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var data: Data
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = Data()
        tv = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.button).setOnClickListener {
            simulateDataChange(it)
        }

        data.digit.observe(this, {
            Log.d("#", "event received: $it. react...")
            tv.text = "data: $it"
        })
    }

    private fun simulateDataChange(v: View?) {
        Log.d("#", "simulate data change")
        data.digit.value = data.digit.value?.plus(2)
    }
}