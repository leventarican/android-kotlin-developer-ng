package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private var shoeList: MutableList<Shoe> = mutableListOf()
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    fun storeShoe(shoe: Shoe) {
        shoeList.add(shoe)
        _shoes.value = shoeList
    }

}