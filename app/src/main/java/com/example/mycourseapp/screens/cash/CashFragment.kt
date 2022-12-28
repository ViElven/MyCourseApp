package com.example.mycourseapp.screens.cash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseapp.R
import com.example.mycourseapp.databinding.FragmentCashBinding
import com.example.mycourseapp.screens.non_cash.NonCashAdapter
import com.example.mycourseapp.screens.non_cash.NonCashViewModel


class CashFragment : Fragment() {
    lateinit var binding: FragmentCashBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CashAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(CashViewModel::class.java)
        binding = FragmentCashBinding.inflate(layoutInflater, container, false)


        recyclerView = binding.rvCash
        adapter = CashAdapter()
        recyclerView.adapter = adapter
        viewModel.getCashMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner,
            { list ->
                list.body()?.let { adapter.setList(it) }
            })

        onClick(viewModel)
        return binding.root
    }

    fun onClick(viewModel: CashViewModel){
        val button = binding.refreshButtonCash
        button.setOnClickListener{
            viewModel.getCashMoney()
            viewModel.myMoneyList.observe(viewLifecycleOwner,
                {list -> list.body()?.let { adapter.setList(it) }
                })
            Toast.makeText(requireContext(), "Refreshed", Toast.LENGTH_LONG).show()
        }
    }
}