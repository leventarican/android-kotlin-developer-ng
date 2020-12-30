package com.github.leventarican.applivedata

import androidx.lifecycle.MutableLiveData

class Data {
    var digit: MutableLiveData<Int> = MutableLiveData()

    init {
        digit.value = 0
    }
}
