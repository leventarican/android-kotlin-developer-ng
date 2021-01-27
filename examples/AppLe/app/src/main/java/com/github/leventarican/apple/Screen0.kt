package com.github.leventarican.apple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.leventarican.apple.databinding.FragmentScreen0Binding

class Screen0 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScreen0Binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_screen0, container, false)
        return binding.root
    }
}