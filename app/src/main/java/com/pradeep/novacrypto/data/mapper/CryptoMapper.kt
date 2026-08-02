package com.pradeep.novacrypto.data.mapper

import com.pradeep.novacrypto.data.dto.GlobalDataDto
import com.pradeep.novacrypto.domain.model.GlobalMarket

fun GlobalDataDto.toGlobalMarket(): GlobalMarket {
    val btc = data.marketCapPercentage["btc"] ?: 0.0
    val eth = data.marketCapPercentage["eth"] ?: 0.0

    return GlobalMarket(
        marketCap = data.totalMarketCap["usd"] ?: 0.0,
        volume24hrs = data.totalVolume["usd"] ?: 0.0,
        volume24hrsPercent = data.volumeChange24hUsd,
        btcPercentage = btc,
        ethPercentage = eth,
        othersPercentage = 100 - btc - eth
    )
}