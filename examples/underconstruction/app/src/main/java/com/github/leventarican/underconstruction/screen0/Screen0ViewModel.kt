package com.github.leventarican.underconstruction.screen0

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Screen0ViewModel : ViewModel() {
    companion object {
        const val max = 3
    }

    private val _data = MutableLiveData<Int>()
    val data: LiveData<Int>
        get() = _data

    init {
        _data.value = 0
    }

    fun increase() {
        _data.value = _data.value?.plus(1)
    }
}