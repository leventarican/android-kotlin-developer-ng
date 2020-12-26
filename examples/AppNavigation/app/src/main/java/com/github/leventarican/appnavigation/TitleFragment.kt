package com.github.leventarican.appnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)

        view.findViewById<Button>(R.id.aboutButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_aboutFragment)
        }

        return view
    }
}