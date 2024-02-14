package com.ihiviko.dogedex.doglist

import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.api.DogsApi.retrofitService
import com.ihiviko.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){ //descargar tarea(Dispatcher) de internet (IO) secundario
        val dogListApiResponse = retrofitService.getAllDogs()
        //getFakeDogs()
            val dogDTOList = dogListApiResponse.data.dogs//el ultimo valor que se regresa de esta lamda
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }

}