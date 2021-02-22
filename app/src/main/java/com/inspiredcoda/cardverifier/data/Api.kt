package com.inspiredcoda.cardverifier.data

import com.inspiredcoda.cardverifier.data.response.CardDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{serials}")
    suspend fun getCardDetails(@Path("serials") serials: String): Response<CardDetailsResponse?>

}