package com.github.leventarican.appfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

/**
 * This activity will host our fragments: single activity
 *
 * https://www.youtube.com/watch?v=2k8x8V77CrU
 * https://www.toptal.com/android/android-fragment-navigation-pattern
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            if (savedInstanceState == null) {
                val transaction = supportFragmentManager.beginTransaction()
                for (i in 0..3) {
                    transaction.add(R.id.ll, AboutFragment.newInstance())
                }
                transaction.commit()
            }
        }
    }
}