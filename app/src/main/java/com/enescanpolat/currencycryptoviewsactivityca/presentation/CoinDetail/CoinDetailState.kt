package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinDetail

import com.enescanpolat.currencycryptoviewsactivityca.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coinDetail:CoinDetail?=null,
    val error:String=""
)