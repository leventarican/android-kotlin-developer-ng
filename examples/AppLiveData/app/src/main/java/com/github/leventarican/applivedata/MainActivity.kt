package com.github.leventarican.applivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val data = Data()
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById<TextView>(R.id.textView)
        updateUI()

        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            Log.d("#", "data changed ...")
            simulateDataChange(it)
        }
    }

    private fun updateUI() {
        tv.text = "data: ${data.value}"
    }

    private fun simulateDataChange(v: View?) {
        data.value = data.value++
    }
}