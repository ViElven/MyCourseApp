package com.example.mycourseapp.screens.cash

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseapp.R
import com.example.mycourseapp.databinding.ItemMoneyLayoutBinding
import com.example.mycourseapp.model.cash.CashModelItem

class CashAdapter: RecyclerView.Adapter<CashAdapter.CashViewHolder>() {

    private var listCash = emptyList<CashModelItem>()


    class CashViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemMoneyLayoutBinding.bind(view)

        fun bind(item: CashModelItem) = with(binding){
            itemName.text = item.ccy
            itemBuy.text = item.buy
            itemSale.text =  item.sale

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return CashViewHolder(view)

    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int){
        holder.bind(listCash[position])

    }

    override fun getItemCount(): Int {
        return  listCash.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CashModelItem>){
        listCash = list
        notifyDataSetChanged()
    }
}