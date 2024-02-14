package com.ihiviko.dogedex.api.dto

import com.ihiviko.dogedex.Dog

class DogDTOMapper {
     private fun fromDogDTOToDogDomain(dogDTO: DogDTO):Dog {
        return Dog(
            dogDTO.id, dogDTO.index, dogDTO.name, dogDTO.type,
            dogDTO.heightFemale, dogDTO.heightMale, dogDTO.imageUrl, dogDTO.lifeExpectancy,
            dogDTO.temperament, dogDTO.weightFemale, dogDTO.weightMale)
    }

    fun fromDogDTOListToDogDomainList(dogDTOList : List<DogDTO>): List<Dog> {
        return dogDTOList.map { fromDogDTOToDogDomain(it) } //map itera para cada elemento DogDto y lo entrega transformado
    }
}