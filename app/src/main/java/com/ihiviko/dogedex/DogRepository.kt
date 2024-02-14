package com.ihiviko.dogedex

import com.ihiviko.dogedex.api.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){ //descargar tarea(Dispatcher) de internet (IO) secundario
        retrofitService.getAllDogs()
        //getFakeDogs()
        }
    }

    private fun getFakeDogs(): MutableList<Dog> {
        val dogList = mutableListOf<Dog>()
        dogList.add(
            Dog(1,1,"Chiguagua", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        dogList.add(
            Dog(2,1,"Labrador", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        dogList.add(
            Dog(3,1,"Retriever", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        dogList.add(
            Dog(4,1,"San Bernardo", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        dogList.add(
            Dog(5,1,"Husky", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        dogList.add(
            Dog(6,1,"Xoloscuincle", "Toy", 5.4,
                6.7,"","12 - 15","",10.5, 12.3)
        )
        return dogList
    }
}