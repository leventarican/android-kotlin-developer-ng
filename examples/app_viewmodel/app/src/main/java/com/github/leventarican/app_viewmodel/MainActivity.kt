package com.github.leventarican.app_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var value = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increase(v: View) {
        value++;
        display();
    }

    fun decrease(v: View) {
        value--;
        display();
    }

    private fun display() {
        val tv = findViewById<TextView>(R.id.textView);
        tv.text = value.toString();
    }
}