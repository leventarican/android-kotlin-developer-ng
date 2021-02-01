package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private lateinit var shoeList: MutableList<Shoe>

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    fun storeShoe(shoe: Shoe) {
        shoe.let {
            shoeList.add(it)
            // fire event / trigger observer
            _shoes.value = shoeList
        }
    }

    fun initShoes() {
        shoeList = mutableListOf()
        storeShoe(
            Shoe("java", 15.0, ".java", "run everywhere")
        )
        storeShoe(Shoe("kotlin", 1.3, ".kt", "concise"))
        storeShoe(Shoe("rust", 1.49, ".rs", "safe"))
    }
}