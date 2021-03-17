package com.github.leventarican.underconstruction.screen0

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.leventarican.underconstruction.R

class Screen0Fragment : Fragment() {

    companion object {
        fun newInstance() = Screen0Fragment()
    }

    private lateinit var viewModel: Screen0ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen0_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Screen0ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}