package com.github.leventarican.underconstruction.screen0

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.github.leventarican.underconstruction.R
import com.github.leventarican.underconstruction.databinding.Screen0FragmentBinding

class Screen0Fragment : Fragment() {

    companion object {
        fun newInstance() = Screen0Fragment()
    }

    private lateinit var viewModel: Screen0ViewModel
    private lateinit var binding: Screen0FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.screen0_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Screen0ViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.d("#", "data increased: $it")
        })
    }

}