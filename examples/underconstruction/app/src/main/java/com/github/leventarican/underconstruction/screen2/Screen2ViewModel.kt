package com.github.leventarican.underconstruction.screen2

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class Screen2ViewModel : ViewModel() {

    private var _start = MutableLiveData<Long>()
    private var _stop = MutableLiveData<Long>()
    val start: LiveData<Long>
        get() {
            return _start
        }
    val stop: LiveData<Long>
        get() {
            return _stop
        }

    fun onStart() {
        Log.d("#", "start ...")

        // we are using kotlin coroutine
        viewModelScope.launch {
            _start.value = System.currentTimeMillis()
        }
    }

    fun onStop() {
        viewModelScope.launch {
            _stop.value = System.currentTimeMillis()
        }
    }

    val startButtonVisible = true

    val stopButtonVisible = Transformations.map(_stop) {
        false
    }

}