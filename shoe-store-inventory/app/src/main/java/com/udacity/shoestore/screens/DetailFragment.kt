package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class DetailFragment : Fragment() {

    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.btSave.setOnClickListener { view ->
            val name = binding.etName.text.toString()
            val size = binding.etSize.text.toString().toDouble()
            val company = binding.etCompany.text.toString()
            val description = binding.etDescription.text.toString()
            viewModel.storeShoe(Shoe(name, size, company, description, listOf("")))
            view.findNavController().navigate(R.id.action_detailFragment_to_listingFragment)
        }
        binding.btCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_listingFragment))

        return binding.root
    }

}