package com.enescanpolat.currencycryptoviewsactivityca.domain.use_cases

import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinListDto.toCoin
import com.enescanpolat.currencycryptoviewsactivityca.domain.model.Coin
import com.enescanpolat.currencycryptoviewsactivityca.domain.repository.CoinRepository
import com.enescanpolat.currencycryptoviewsactivityca.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository){




    operator fun invoke(page:String): Flow<Resource<List<Coin>>> = flow {


        try {
            emit(Resource.Loading())
            val coinList=repository.getAllCoins(page).map {
                it.toCoin()
            }
            emit(Resource.Success(coinList))



        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Internet ERROR",null))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?:"Input Output ERROR",null))
        }


    }
}