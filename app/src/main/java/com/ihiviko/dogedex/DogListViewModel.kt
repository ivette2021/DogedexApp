package com.ihiviko.dogedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {

    private val dogRepository = DogRepository()
    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {

        }
    }
}