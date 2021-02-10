package com.github.leventarican.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.github.leventarican.broadcast.MainActivity.Companion.ACTION_L_EVENT

class CustomReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ACTION_L_EVENT) {
            val value = intent.getStringExtra(MainActivity.ACTION_L_EVENT_KEY)
            val msg = "message received: $value; action: ${intent?.action}"
            Log.d("#", msg)
        }
    }

}