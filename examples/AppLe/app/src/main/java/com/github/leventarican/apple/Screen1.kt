package com.github.leventarican.apple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.leventarican.apple.databinding.FragmentScreen1Binding

class Screen1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScreen1Binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_screen1, container, false)
        return binding.root
    }
}