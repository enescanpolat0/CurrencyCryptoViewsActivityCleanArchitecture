package com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.enescanpolat.currencycryptoviewsactivityca.databinding.CoinRecyclerViewBinding
import com.enescanpolat.currencycryptoviewsactivityca.domain.model.Coin
import com.enescanpolat.currencycryptoviewsactivityca.presentation.CoinDetail.CoinActivity
import com.squareup.picasso.Picasso

class CoinAdapter(private val context:Context,var coinList : ArrayList<Coin>)
    :RecyclerView.Adapter<CoinAdapter.CoinviewHolder>(),Filterable
{
    lateinit var filteredList : ArrayList<Coin>

    inner class CoinviewHolder(val binding : CoinRecyclerViewBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinviewHolder {
        val binding = CoinRecyclerViewBinding.inflate(LayoutInflater.from(context),parent,false)
        return CoinviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: CoinviewHolder, position: Int) {
        val coin = coinList[position]
        holder.binding.txtCoinName.text = coin.name.toString()
        holder.binding.coinLinearLayout.setOnClickListener {
            val intent = Intent(context,CoinActivity::class.java)
            intent.putExtra("id",coin.id)
            context.startActivity(intent)
        }
        Picasso.get().load(coin.image).into(holder.binding.imgCoinImage)
    }

    fun setData(list:ArrayList<Coin>){
        this.filteredList = list
        this.coinList = list
        notifyDataSetChanged()

    }

    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val string = p0?.toString()?:""
                if (string.isNotEmpty()){
                    var arrayList = arrayListOf<Coin>()
                    filteredList.filter {
                        it.name.lowercase().contains(string.lowercase())
                    }.forEach{
                        arrayList.add(it)
                    }
                    filteredList.clear()
                    filteredList.addAll(arrayList)
                }else{
                    filteredList = coinList
                }
                return FilterResults().apply {
                    this.values = filteredList
                }
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                if (p1?.values==null){
                    ArrayList<Coin>()
                }else{
                    setData(filteredList)
                }
            }

        }
    }
}