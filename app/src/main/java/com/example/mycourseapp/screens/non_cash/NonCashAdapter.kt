package com.example.mycourseapp.screens.non_cash

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseapp.R
import com.example.mycourseapp.databinding.ItemMoneyLayoutBinding
import com.example.mycourseapp.model.non_cash.NonCashModelItem

class NonCashAdapter: RecyclerView.Adapter<NonCashAdapter.NonCashViewHolder>() {


    private var listNonCash = emptyList<NonCashModelItem>()
    class NonCashViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = ItemMoneyLayoutBinding.bind(view)

        fun bind(item: NonCashModelItem) = with(binding){
            itemName.text = item.ccy
            itemBuy.text = item.buy
            itemSale.text =  item.sale

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonCashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return NonCashViewHolder(view)

    }

    override fun onBindViewHolder(holder: NonCashViewHolder, position: Int){
        holder.bind(listNonCash[position])

    }

    override fun getItemCount(): Int {
        return  listNonCash.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NonCashModelItem>){
        listNonCash = list
        notifyDataSetChanged()
    }
}