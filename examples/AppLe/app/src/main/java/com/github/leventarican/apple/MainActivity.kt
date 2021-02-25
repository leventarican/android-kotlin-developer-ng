package com.github.leventarican.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.github.leventarican.apple.databinding.ActivityMainBinding

/**
 * the main activity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // without data binding
//        setContentView(R.layout.activity_main)

        // with data binding
        // https://github.com/google-developer-training/android-kotlin-fundamentals-apps/blob/master/AboutMeDataBinding/app/src/main/java/com/example/android/aboutme/MainActivity.kt
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // for fragments
        // https://developer.android.com/codelabs/kotlin-android-training-create-and-add-fragment?index=..%2F..android-kotlin-fundamentals#3
//        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}