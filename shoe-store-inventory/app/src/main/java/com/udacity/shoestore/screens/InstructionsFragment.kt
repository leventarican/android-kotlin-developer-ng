package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_listingFragment))
        return binding.root
    }

}