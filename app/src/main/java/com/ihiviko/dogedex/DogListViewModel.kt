package com.ihiviko.dogedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {


    private val _dogList = MutableLiveData<List<Dog>>()

    //principio de encapsulamiento  livedata solo se podra leer pero no editar(fuera del viewmodel)
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }
}