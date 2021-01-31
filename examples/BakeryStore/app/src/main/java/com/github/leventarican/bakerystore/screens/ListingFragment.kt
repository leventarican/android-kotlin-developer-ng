package com.github.leventarican.bakerystore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.github.leventarican.bakerystore.R
import com.github.leventarican.bakerystore.databinding.FragmentListingBinding
import com.github.leventarican.bakerystore.databinding.FragmentWelcomeBinding

class ListingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)
        binding.button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listingFragment_to_detailFragment))
        return binding.root
    }

}