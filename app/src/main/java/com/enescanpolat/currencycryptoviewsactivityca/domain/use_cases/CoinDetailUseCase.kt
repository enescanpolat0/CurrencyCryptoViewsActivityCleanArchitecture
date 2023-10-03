package com.enescanpolat.currencycryptoviewsactivityca.domain.use_cases


import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CoinDetailDto
import com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.toCoinDetail
import com.enescanpolat.currencycryptoviewsactivityca.domain.model.CoinDetail
import com.enescanpolat.currencycryptoviewsactivityca.domain.repository.CoinRepository
import com.enescanpolat.currencycryptoviewsactivityca.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(id:String): Flow<Resource<CoinDetail>> = flow {


        try {
            emit(Resource.Loading())
            val coin=repository.getCoinById(id).toCoinDetail()
            emit(Resource.Success(coin))


        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Internet ERROR",null))
        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage?:"Input Output ERROR",null))
        }


    }



}