package com.enescanpolat.currencycryptoviewsactivityca.domain.model

data class CoinDetail(
    val name:String,
    val image:String,
    val market_cap:String,
    val price:Double,
    val price_precent_change:Double,
    val lowPrice:Double,
    val highPrice:Double,
    val description : String
)
