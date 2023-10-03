package com.enescanpolat.currencycryptoviewsactivityca.data.depenencyinjection

import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.CoinCurrencyAPI
import com.enescanpolat.currencycryptoviewsactivityca.data.repository.CoinRepositoryImpl
import com.enescanpolat.currencycryptoviewsactivityca.domain.repository.CoinRepository
import com.enescanpolat.currencycryptoviewsactivityca.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appModule {


    @Singleton
    @Provides
    fun injectCoinCurrencyApi():CoinCurrencyAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinCurrencyAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectCoinRepository(api: CoinCurrencyAPI):CoinRepository{
        return CoinRepositoryImpl(api)
    }


}