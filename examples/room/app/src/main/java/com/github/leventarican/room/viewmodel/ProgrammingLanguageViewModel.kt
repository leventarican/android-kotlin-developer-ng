package com.github.leventarican.room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.github.leventarican.room.repository.ProgrammingLanguageRepository
import com.github.leventarican.room.room.ProgrammingLanguage
import kotlinx.coroutines.launch

/**
 * delegate operation (query, insert, ...) to repository.
 */
class ProgrammingLanguageViewModel(private val repository: ProgrammingLanguageRepository) : ViewModel() {
    val allLanguages: LiveData<List<ProgrammingLanguage>> = repository.allLanguages.asLiveData()

    // using kotlin coroutine
    fun insert(language: ProgrammingLanguage) = viewModelScope.launch {
        repository.insert(language)
    }
}