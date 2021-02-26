package com.github.leventarican.apple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.leventarican.apple.databinding.FragmentScreen0Binding

class Screen0 : Fragment() {

    lateinit var binding: FragmentScreen0Binding

    // It is recommended to only inflate the layout in this method
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_screen0, container, false)

        // Notify the system to allow an options menu for this fragment.
        // TODO: onCreateOptionsMenu, onOptionsItemSelected
//        setHasOptionsMenu(true)

        return binding.root
    }

    // This method can be used to do final initialization
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this.viewLifecycleOwner
        setupSwipeRefreshLayout(binding.screen0SwipeRefreshLayout, binding.screen0List)
    }

    private fun setupSwipeRefreshLayout(layout: ExtendedSwipeRefreshLayout, viewToScroll: View) {
        viewToScroll?.let {
            layout.viewToScroll = it
        }
    }
}