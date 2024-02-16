package com.ihiviko.dogedex.doglist

import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.R
import com.ihiviko.dogedex.api.DogsApi.retrofitService
import com.ihiviko.dogedex.api.dto.DogDTOMapper
import com.ihiviko.dogedex.api.responses.ApiResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {
    suspend fun downloadDogs(): ApiResponseStatus {
        return withContext(Dispatchers.IO) {
            try {
                //descargar tarea(Dispatcher) de internet (IO) secundario
                val dogListApiResponse = retrofitService.getAllDogs()
                //getFakeDogs()
                val dogDTOList =
                    dogListApiResponse.data.dogs//el ultimo valor que se regresa de esta lamda
                val dogDTOMapper = DogDTOMapper()
                dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
                ApiResponseStatus.Success(dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList))
            } catch (e: UnknownHostException) {
                ApiResponseStatus.Error(R.string.unknown_host_exception_error)
            } catch (e: Exception) {
                ApiResponseStatus.Error(R.string.unknown_error)
            }

        }
    }

}