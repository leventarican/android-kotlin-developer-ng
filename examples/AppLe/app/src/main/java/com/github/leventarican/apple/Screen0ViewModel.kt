package com.github.leventarican.apple

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * TODO: when extend AndroidViewModel and when ViewModel?
 */
class Screen0ViewModel : ViewModel() {

    // kotlin: backing properties
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    // used by setOnRefreshListener
    fun operation() {
        Log.d("#", "doing operation")
        viewModelScope.launch {
            //_dataLoading.value = true
            arrayOf(100).iterator().forEach {
                Log.d("#", "operation on refresh: $it")
            }
            _dataLoading.value = false
        }
    }
}