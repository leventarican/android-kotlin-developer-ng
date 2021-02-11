package com.github.leventarican.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.github.leventarican.broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btBroadcast.setOnClickListener {
            Log.d("#", "broadcast")
            val intent = Intent(this, CustomReceiver::class.java)
            intent.action = ACTION_L_EVENT
            intent.putExtra(ACTION_L_EVENT_KEY, "hello")
            sendBroadcast(intent)
        }

        binding.btIntents.setOnClickListener {
            Log.d("#", "intent")
            startActivity(Intent(this, DeveloperActivity::class.java).also {
                it.putExtra(DEVELOPER_KEY, Developer(0, "Rust", 2))
            })
        }
    }

    companion object {
        internal const val ACTION_L_EVENT = "com.github.leventarican.MESSAGE"
        internal const val ACTION_L_EVENT_KEY = "KEY"
        internal const val DEVELOPER_KEY = "DEV"
    }
}
