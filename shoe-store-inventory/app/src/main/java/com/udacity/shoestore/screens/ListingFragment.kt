package com.udacity.shoestore.screens

import android.graphics.fonts.Font
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel

class ListingFragment : Fragment() {

    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)

        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)

        // data binding
        binding.shoesViewModel = viewModel

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            it.forEach { shoe -> binding.llListing.addView(textViewFrom(shoe)) }
        })
        viewModel.initShoes()

        binding.fabListing.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listingFragment_to_detailFragment))

        return binding.root
    }

    private fun textViewFrom(shoe: Shoe): TextView {
        val tv = TextView(context)
        tv.text = "${shoe.name}, ${shoe.size}"
        tv.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        tv.textSize = 36.0F
        return tv
    }

}