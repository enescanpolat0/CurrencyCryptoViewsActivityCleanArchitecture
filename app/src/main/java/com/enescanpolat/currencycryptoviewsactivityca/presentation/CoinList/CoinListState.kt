package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinList

import com.enescanpolat.currencycryptoviewsactivityca.domain.model.Coin


data class CoinListState(
    val isloading : Boolean = false,
    val coinList : List<Coin> = emptyList(),
    val error : String =""

)
