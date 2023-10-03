package com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto

data class Ticker(
    val base: String,
    val bid_ask_spread_percentage: Double,
    val coin_id: String,
    val converted_last: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.ConvertedLast,
    val converted_volume: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.ConvertedVolume,
    val is_anomaly: Boolean,
    val is_stale: Boolean,
    val last: Double,
    val last_fetch_at: String,
    val last_traded_at: String,
    val market: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Market,
    val target: String,
    val target_coin_id: String,
    val timestamp: String,
    val token_info_url: Any,
    val trade_url: String,
    val trust_score: String,
    val volume: Double
)