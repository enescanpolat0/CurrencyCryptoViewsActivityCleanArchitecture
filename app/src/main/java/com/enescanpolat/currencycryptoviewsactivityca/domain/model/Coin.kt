package com.enescanpolat.currencycryptoviewsactivityca.domain.model

data class Coin(
    val id:String,
    val name:String,
    val image:String,
    val marketcap:Long,
    val price:Double,
    val price_percent_change:Double,
    val lowPrice:Double,
    val highPrice:Double
)
