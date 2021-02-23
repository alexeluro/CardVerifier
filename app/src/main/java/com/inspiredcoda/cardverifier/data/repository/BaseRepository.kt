package com.inspiredcoda.cardverifier.data.repository

import com.inspiredcoda.cardverifier.utils.ApiException
import retrofit2.Response

abstract class BaseRepository {

    suspend fun<T> apiRequest(work: suspend (() -> Response<T?>)): T?{
        val request = work.invoke()

        if (request.isSuccessful){
            return request.body()
        }else{

            throw ApiException("Error fetching card details!")

        }

    }


}