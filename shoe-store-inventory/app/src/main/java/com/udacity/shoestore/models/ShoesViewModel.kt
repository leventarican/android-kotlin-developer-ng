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
            _shoes.value = shoeList
        }
    }

//    init {
//        fillShoes()
//    }
//
//    private fun fillShoes() {
//        shoeList = mutableListOf(
//            Shoe("java", 15.0, ".java", "buy once wear everywhere"),
//            Shoe("kotlin", 1.3, ".kt", "concise"),
//            Shoe("rust", 1.49, ".rs", "safe")
//        )
//    }
}