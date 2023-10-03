package com.enescanpolat.currencycryptoviewsactivityca.data.repository

import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.CoinCurrencyAPI
import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinListDto.CoinListDtoItem
import com.enescanpolat.currencycryptoviewsactivityca.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinCurrencyAPI
):CoinRepository {
    override suspend fun getAllCoins(page: String): List<CoinListDtoItem> {
        return api.getAllCoins(page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}