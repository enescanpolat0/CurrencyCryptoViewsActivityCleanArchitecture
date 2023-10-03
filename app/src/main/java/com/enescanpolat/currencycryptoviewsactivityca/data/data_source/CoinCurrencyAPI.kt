package com.enescanpolat.currencycryptoviewsactivityca.data.data_source

import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinListDto.CoinListDtoItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinCurrencyAPI {


    @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en")
    suspend fun getAllCoins(@Query("page")page:String):List<CoinListDtoItem>

    @GET("/api/v3/coins/{id}")
    suspend fun getCoinById(@Path("id")id:String):CoinDetailDto
}