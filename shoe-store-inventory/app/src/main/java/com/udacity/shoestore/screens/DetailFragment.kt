package com.udacity.shoestore.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class DetailFragment : Fragment() {

    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoesViewModel::class.java)
        Log.d("#", "viewmodel size: ${viewModel.shoes.value?.size}")

        binding.btSave.setOnClickListener { view ->
            val name = binding.etName.text.toString()
            val size = binding.etSize.text.toString().toDouble()
            Log.d("#", "save data: $name; $size")
            viewModel.storeShoe(Shoe(name, size, "", "", listOf("")))
            view.findNavController().navigate(R.id.action_detailFragment_to_listingFragment)
        }
        binding.btCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listingFragment))

        return binding.root
    }

}