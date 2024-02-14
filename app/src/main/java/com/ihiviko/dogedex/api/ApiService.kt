package com.ihiviko.dogedex.api

import com.ihiviko.dogedex.BASE_URL
import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.GET_ALL_DOGS_URL
import com.ihiviko.dogedex.responses.DogListApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
interface ApiService {
    @GET(GET_ALL_DOGS_URL) //VARIABLE QUE ESTA EN OTRA CLASE (CONSTANTES)
//    suspend fun  getAllDogs() : List<Dog>
    suspend fun  getAllDogs() : DogListApiResponse
}

object DogsApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}