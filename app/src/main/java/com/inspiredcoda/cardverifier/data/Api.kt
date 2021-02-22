package com.inspiredcoda.cardverifier.data

import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{serials}")
    suspend fun getCardDetails(@Path("serials") serials: String)

}