package com.ihiviko.dogedex.api.responses

import com.ihiviko.dogedex.Dog

//sealed class parecida a enum cambia la estructura de los datos
sealed class ApiResponseStatus<T> { //T es para que funcione para cualquier tipo dato
    class Success<T>(val data: T) : ApiResponseStatus<T>()
    class Loading<T>: ApiResponseStatus<T>()
    class Error<T>(val messageId: Int): ApiResponseStatus<T>()
}