package com.ihiviko.dogedex.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.api.responses.ApiResponseStatus
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {


    private val _dogList = MutableLiveData<List<Dog>>()

    //principio de encapsulamiento  livedata solo se podra leer pero no editar(fuera del viewmodel)
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val _status = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus>
        get() = _status

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
              handleresponseStatus(dogRepository.downloadDogs())
        }
    }

    private fun handleresponseStatus(apiResponseStatus: ApiResponseStatus) {
        if (apiResponseStatus is ApiResponseStatus.Success) {
            _dogList.value = apiResponseStatus.dogList
        }
        _status.value = apiResponseStatus
    }
}