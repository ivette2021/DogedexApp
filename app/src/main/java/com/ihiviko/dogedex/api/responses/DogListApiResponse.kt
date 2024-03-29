package com.ihiviko.dogedex.api.responses

import com.squareup.moshi.Json

class DogListApiResponse (
    val message: String,
    @field:Json(name = "is_success")val isSuccess : Boolean, //le agregamos el json porque en la api el nombre es como esta en verde
    val data: DogListResponse,
)
