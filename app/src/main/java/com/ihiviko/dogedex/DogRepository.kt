package com.ihiviko.dogedex

import com.ihiviko.dogedex.api.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){ //descargar tarea(Dispatcher) de internet (IO) secundario
        val dogListApiResponse = retrofitService.getAllDogs()
        //getFakeDogs()
            dogListApiResponse.data.dogs//el ultimo valor que se regresa de esta lamda
        }
    }

}