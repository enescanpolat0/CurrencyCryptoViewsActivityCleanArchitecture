package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinDetail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.enescanpolat.currencycryptoviewsactivityca.databinding.ActivityCoinBinding
import com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinDetail.CoinDetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class CoinActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCoinBinding
    private val coinDetailViewModel : CoinDetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let {
            val coinId = it.getStringExtra("id")?:""
            if (coinId.isNotBlank()){
                coinDetailViewModel.getCoinDetailById(coinId.toString())
                observeCoinDetails()
            }else{
                Toast.makeText(this@CoinActivity,"We have not Id to Call",Toast.LENGTH_LONG).show()
            }


        }

    }


    private fun observeCoinDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            coinDetailViewModel._coinDetailValue.collectLatest {coinDetailValue->

                withContext(Dispatchers.Main){



                if(coinDetailValue.isLoading){
                    binding.coinProggresBar.visibility= View.VISIBLE
                }else if(coinDetailValue.error.isNotBlank()){
                    binding.coinProggresBar.visibility= View.GONE
                    Toast.makeText(this@CoinActivity,coinDetailValue.error,Toast.LENGTH_LONG).show()
                }else{
                    binding.coinProggresBar.visibility= View.GONE
                    coinDetailValue.coinDetail?.let {coinDetail->

                        Picasso.get().load(coinDetail.image).into(binding.imgCoinImageDetail)
                        binding.txtCoinNameDetail.text = "Coin Name: ${coinDetail.name}"
                        binding.txtCoinPrice.text="Coin Price: ${coinDetail.price}"
                        binding.txtCoinPriceLow.text="Low Price: ${coinDetail.lowPrice}"
                        binding.txtCoinPriceHigh.text="High Price: ${coinDetail.highPrice}"
                        binding.txtCoinMarketCap.text="Market Cap: ${coinDetail.market_cap}"
                        binding.txtCoinPricePercentChange.text="Coin Price Percent Change: ${coinDetail.price_precent_change}"


                    }

                  }

                }

            }
        }
    }
}