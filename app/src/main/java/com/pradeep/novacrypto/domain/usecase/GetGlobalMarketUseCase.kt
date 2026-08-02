package com.pradeep.novacrypto.domain.usecase

import com.pradeep.novacrypto.core.common.ApiResult
import com.pradeep.novacrypto.domain.model.GlobalMarket
import com.pradeep.novacrypto.domain.repository.MarketsRepository
import javax.inject.Inject

class GetGlobalMarketUseCase @Inject constructor(
    private val marketsRepository: MarketsRepository
) {

    suspend operator fun invoke(): ApiResult<GlobalMarket> = marketsRepository.getGlobalMarketData()
}