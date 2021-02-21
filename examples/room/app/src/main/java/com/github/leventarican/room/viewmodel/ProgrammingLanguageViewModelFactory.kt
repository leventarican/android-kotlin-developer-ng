package com.github.leventarican.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.leventarican.room.repository.ProgrammingLanguageRepository

class ProgrammingLanguageViewModelFactory(private val repository: ProgrammingLanguageRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProgrammingLanguageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProgrammingLanguageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}