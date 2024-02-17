package com.ihiviko.dogedex.doglist

import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.api.DogsApi.retrofitService
import com.ihiviko.dogedex.api.dto.DogDTOMapper
import com.ihiviko.dogedex.api.makeNetworkCall
import com.ihiviko.dogedex.api.responses.ApiResponseStatus

class DogRepository {
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall { //se reemplazo el return por un signo igual
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs//el ultimo valor que se regresa de esta lamda
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
