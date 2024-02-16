package com.ihiviko.dogedex.api.responses

import com.ihiviko.dogedex.Dog

sealed class ApiResponseStatus() { //sealed class parecida a enum cambia la estructura de los datos
    class Success(val dogList: List<Dog>) : ApiResponseStatus()
    class Loading(): ApiResponseStatus()
    class Error(val messageId: Int): ApiResponseStatus()
}