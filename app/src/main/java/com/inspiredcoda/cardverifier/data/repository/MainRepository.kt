package com.inspiredcoda.cardverifier.data.repository

import com.inspiredcoda.cardverifier.data.Api
import com.inspiredcoda.cardverifier.data.response.CardDetailsResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
        private val api: Api
): BaseRepository() {

    suspend fun getCardDetails(serials: String): CardDetailsResponse?{
        return apiRequest { api.getCardDetails(serials) }
    }


}