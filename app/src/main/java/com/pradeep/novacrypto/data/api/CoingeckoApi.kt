package com.pradeep.novacrypto.data.api

import com.pradeep.novacrypto.data.dto.GlobalDataDto
import retrofit2.http.GET

interface CoingeckoApi {

    @GET("global")
    suspend fun getGlobalData(): GlobalDataDto
}