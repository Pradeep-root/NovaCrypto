package com.pradeep.novacrypto.domain.repository

import com.pradeep.novacrypto.core.common.ApiResult
import com.pradeep.novacrypto.domain.model.GlobalMarket

interface MarketsRepository {

    suspend fun getGlobalMarketData() : ApiResult<GlobalMarket>

}