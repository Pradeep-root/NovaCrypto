package com.pradeep.novacrypto.data.repository

import com.pradeep.novacrypto.core.NetworkErrorMapper
import com.pradeep.novacrypto.core.common.ApiResult
import com.pradeep.novacrypto.core.dispature.DispatcherProvider
import com.pradeep.novacrypto.data.api.CoingeckoApi
import com.pradeep.novacrypto.data.mapper.toGlobalMarket
import com.pradeep.novacrypto.domain.model.GlobalMarket
import com.pradeep.novacrypto.domain.repository.MarketsRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarketsRepositoryImpl @Inject constructor(
    private val api: CoingeckoApi,
    private val dispatcherProvider: DispatcherProvider,
    private val networkErrorMapper: NetworkErrorMapper
) : MarketsRepository {


    override suspend fun getGlobalMarketData(): ApiResult<GlobalMarket> =
        withContext(dispatcherProvider.io) {
            try {
                val response = api.getGlobalData()
                ApiResult.Success(response.toGlobalMarket())
            } catch (e: Exception) {
                ApiResult.Error(networkErrorMapper.map(e))
            }
        }

}