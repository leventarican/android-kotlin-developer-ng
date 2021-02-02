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

//    init {
//        storeShoe(
//            Shoe("java", 15.0, ".java", "run everywhere")
//        )
//        storeShoe(Shoe("kotlin", 1.3, ".kt", "concise"))
//        storeShoe(Shoe("rust", 1.49, ".rs", "safe"))
//    }

    fun storeShoe(shoe: Shoe) {
//        shoe.let {
//            shoeList.add(it)
//            Log.d("#", "store shoe: ${shoe.name}")
            // fire event / trigger observer
//            _shoes.value = shoeList
//        }
        Log.d("#", "store shoe: ${shoe.name}; ${shoeList.size}")
        shoeList.add(shoe)
        Log.d("#", "shoe list: ${shoeList.size}")
        _shoes.value = shoeList
    }

}