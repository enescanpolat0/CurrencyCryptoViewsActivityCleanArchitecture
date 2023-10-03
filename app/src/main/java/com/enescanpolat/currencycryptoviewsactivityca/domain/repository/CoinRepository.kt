package com.enescanpolat.currencycryptoviewsactivityca.domain.repository

import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinListDto.CoinListDtoItem
import com.enescanpolat.currencycryptoviewsactivityca.domain.model.CoinDetail

interface CoinRepository {


    suspend fun getAllCoins(page:String):List<CoinListDtoItem>

    suspend fun getCoinById(id:String):CoinDetailDto

}