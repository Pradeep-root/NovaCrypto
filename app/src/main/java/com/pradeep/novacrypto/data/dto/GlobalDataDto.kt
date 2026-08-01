package com.pradeep.novacrypto.data.dto

import com.google.gson.annotations.SerializedName

data class GlobalDataDto(
    val data: GlobalDataResponse
)

data class GlobalDataResponse(
    @SerializedName("active_cryptocurrencies")
    val activeCryptocurrencies: Int,

    @SerializedName("ended_icos")
    val endedIcos: Int,

    @SerializedName("ongoing_icos")
    val ongoingIcos: Int,

    @SerializedName("upcoming_icos")
    val upcomingIcos: Int,

    val markets: Int,

    @SerializedName("updated_at")
    val updatedAt: Long,

    @SerializedName("market_cap_change_percentage_24h_usd")
    val marketCapChange24hUsd: Double,

    @SerializedName("volume_change_percentage_24h_usd")
    val volumeChange24hUsd: Double,

    @SerializedName("market_cap_percentage")
    val marketCapPercentage: Map<String, Double>,

    @SerializedName("total_market_cap")
    val totalMarketCap: Map<String, Double>,

    @SerializedName("total_volume")
    val totalVolume: Map<String, Double>
)