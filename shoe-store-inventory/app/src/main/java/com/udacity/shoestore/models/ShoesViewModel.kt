package com.udacity.shoestore.models

import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private lateinit var shoeList: MutableList<Shoe>

    init {
        fillShoes()
    }

    private fun fillShoes() {
        shoeList = mutableListOf(
            Shoe("java", 15.0, ".java", "buy once wear everywhere"),
            Shoe("kotlin", 1.3, ".kt", "concise"),
            Shoe("rust", 1.49, ".rs", "safe")
        )
    }
}