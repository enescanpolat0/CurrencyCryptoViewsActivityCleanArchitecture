package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.currencycryptoviewsactivityca.domain.use_cases.CoinDetailUseCase
import com.enescanpolat.currencycryptoviewsactivityca.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase: CoinDetailUseCase
):ViewModel() {


    private val coinDetailValue = MutableStateFlow(CoinDetailState())
    val _coinDetailValue : StateFlow<CoinDetailState> = coinDetailValue

    fun getCoinDetailById(id:String) = viewModelScope.launch(Dispatchers.IO) {


        coinDetailUseCase(id).collect{result->


            when(result){
                is Resource.Success->{

                    coinDetailValue.value = CoinDetailState(coinDetail = result.data)

                }
                is Resource.Loading->{

                    coinDetailValue.value = CoinDetailState(isLoading = true)

                }
                is Resource.Error->{

                    coinDetailValue.value = CoinDetailState(error = result.message?:"ERROR")

                }



            }




        }



    }


}