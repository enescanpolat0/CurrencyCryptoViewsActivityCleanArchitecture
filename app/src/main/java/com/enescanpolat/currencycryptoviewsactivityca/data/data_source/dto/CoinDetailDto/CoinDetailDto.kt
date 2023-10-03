package com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto

import com.enescanpolat.currencycryptoviewsactivityca.domain.model.CoinDetail

data class CoinDetailDto(
    val additional_notices: List<Any>,
    val asset_platform_id: Any,
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val coingecko_rank: Int,
    val coingecko_score: Double,
    val community_data: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CommunityData,
    val community_score: Double,
    val country_origin: String,
    val description: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Description,
    val detail_platforms: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.DetailPlatforms,
    val developer_data: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.DeveloperData,
    val developer_score: Double,
    val genesis_date: String,
    val hashing_algorithm: String,
    val id: String,
    val image: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Image,
    val last_updated: String,
    val links: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Links,
    val liquidity_score: Double,
    val localization: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Localization,
    val market_cap_rank: Int,
    val market_data: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.MarketData,
    val name: String,
    val platforms: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Platforms,
    val preview_listing: Boolean,
    val public_interest_score: Double,
    val public_interest_stats: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.PublicInterestStats,
    val public_notice: Any,
    val sentiment_votes_down_percentage: Double,
    val sentiment_votes_up_percentage: Double,
    val status_updates: List<Any>,
    val symbol: String,
    val tickers: List<com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.Ticker>,
    val watchlist_portfolio_users: Int
)

    fun CoinDetailDto.toCoinDetail():CoinDetail{
        return CoinDetail(
            name = name,
            image = image.large,
            price = market_data.market_cap.usd.toDouble(),
            price_precent_change = market_data.price_change_24h_in_currency.usd,
            lowPrice = market_data.low_24h.usd.toDouble(),
            highPrice = market_data.high_24h.usd.toDouble(),
            description = description.en,
            market_cap = market_data.market_cap.usd.toDouble().toString()

        )
    }
