package com.pradeep.novacrypto.domain.model

data class GlobalMarket(
    val marketCap: Double,
    val volume24hrs: Double,
    val volume24hrsPercent: Double,
    val btcPercentage: Double,
    val ethPercentage: Double,
    val othersPercentage: Double
)
