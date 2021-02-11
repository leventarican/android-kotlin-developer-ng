package com.github.leventarican.broadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.leventarican.broadcast.databinding.ActivityDeveloperBinding
import com.github.leventarican.broadcast.MainActivity.Companion.DEVELOPER_KEY

class DeveloperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeveloperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_developer)

        binding.tvDeveloper.apply {
            val dev = intent.extras?.getParcelable<Developer>(DEVELOPER_KEY) as Developer
            this.text = "developer: ${dev.id}; ${dev.programmingLang}; ${dev.exp}"
        }
    }
}
