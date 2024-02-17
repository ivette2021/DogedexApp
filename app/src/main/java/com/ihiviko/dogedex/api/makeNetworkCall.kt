package com.ihiviko.dogedex.api

import com.ihiviko.dogedex.R
import com.ihiviko.dogedex.api.dto.DogDTOMapper
import com.ihiviko.dogedex.api.responses.ApiResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend() -> T
): ApiResponseStatus<T>{
    return withContext(Dispatchers.IO) {
        try {
            ApiResponseStatus.Success(call())
        } catch (e: UnknownHostException) {
            ApiResponseStatus.Error(R.string.unknown_host_exception_error)
        } catch (e: Exception) {
            ApiResponseStatus.Error(R.string.unknown_error)
        }

    }
}