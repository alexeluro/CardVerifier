package com.inspiredcoda.cardverifier.data.repository

import com.inspiredcoda.cardverifier.data.Api
import com.inspiredcoda.cardverifier.data.response.CardDetailsResponse

class MainRepository(private val api: Api): BaseRepository() {

    suspend fun getCardDetails(serials: String): CardDetailsResponse?{
        return apiRequest { api.getCardDetails(serials) }
    }


}