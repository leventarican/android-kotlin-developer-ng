package com.udacity.shoestore.screens

import android.graphics.fonts.Font
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel
import org.w3c.dom.Text

class ListingFragment : Fragment() {

    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)

        // data binding
        binding.shoesViewModel = viewModel

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            it.forEach { shoe ->
                binding.llListing.addView(createViewGroupFrom(shoe))
            }
        })

        binding.fabListing.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listingFragment_to_detailFragment))

        return binding.root
    }

    private fun createViewGroupFrom(shoe: Shoe): View {
        return LinearLayout(context).apply {
            this.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            this.orientation = LinearLayout.VERTICAL
            this.addView(TextView(context).apply {
                this.text = shoe.name
                this.textSize = 36.0F
            })
            this.addView(TextView(context).apply {
                this.text = "${shoe.size}"
                this.textSize = 18.0F
            })
            this.addView(TextView(context).apply {
                this.text = shoe.company
                this.textSize = 18.0F
            })
            this.addView(TextView(context).apply {
                this.text = shoe.description
                this.textSize = 18.0F
            })
        }
    }
}