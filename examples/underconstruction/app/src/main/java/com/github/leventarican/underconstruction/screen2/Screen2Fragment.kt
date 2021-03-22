package com.github.leventarican.underconstruction.screen2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.leventarican.underconstruction.R
import com.github.leventarican.underconstruction.databinding.Screen0FragmentBinding
import com.github.leventarican.underconstruction.databinding.Screen2FragmentBinding
import com.github.leventarican.underconstruction.screen0.Screen0ViewModel
import com.github.leventarican.underconstruction.setTitle

class Screen2Fragment : Fragment() {

    companion object {
        fun newInstance() = Screen2Fragment()
    }

    private lateinit var viewModel: Screen2ViewModel
    private lateinit var binding: Screen2FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.screen2_fragment, container, false)
        setTitle("# screen 2: work time")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Screen2ViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
    }

}