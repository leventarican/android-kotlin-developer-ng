package com.github.leventarican.underconstruction.screen1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.leventarican.underconstruction.R
import com.github.leventarican.underconstruction.setTitle

class Screen1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setTitle("# screen 1")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.screen1_fragment, container, false)
    }
}