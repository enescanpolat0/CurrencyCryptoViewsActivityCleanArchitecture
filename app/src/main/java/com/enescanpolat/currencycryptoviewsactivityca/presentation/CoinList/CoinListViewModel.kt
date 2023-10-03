package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.currencycryptoviewsactivityca.domain.use_cases.CoinListUseCase
import com.enescanpolat.currencycryptoviewsactivityca.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase: CoinListUseCase
):ViewModel() {


    private val coinListValue = MutableStateFlow(CoinListState())
    val _coinListValue : StateFlow<CoinListState> = coinListValue


    fun getAllCoins(page:String) = viewModelScope.launch(Dispatchers.IO) {


        coinListUseCase(page).collect{result->

            when(result){
                is Resource.Success->{

                    coinListValue.value = CoinListState(coinList = result.data?: emptyList())

                }
                is Resource.Loading->{
                    coinListValue.value= CoinListState(isloading = true)
                }
                is Resource.Error->{

                    coinListValue.value=CoinListState(error =result.message?:"ERROR")

                }

            }

        }


    }



}