package com.example.mycourseapp.screens.non_cash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mycourseapp.R
import com.example.mycourseapp.databinding.FragmentNonCashBinding


class NonCashFragment : Fragment() {
    lateinit var binding: FragmentNonCashBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NonCashAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(NonCashViewModel::class.java)
        binding = FragmentNonCashBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.rvNonCash
        adapter = NonCashAdapter()
        recyclerView.adapter = adapter
        viewModel.getNonCashMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner,
            {list -> list.body()?.let { adapter.setList(it) }
        })

        onClick(viewModel)
        return binding.root
    }
    fun onClick(viewModel: NonCashViewModel){
        val button = binding.refreshButtonNonCash
        button.setOnClickListener{
            viewModel.getNonCashMoney()
            viewModel.myMoneyList.observe(viewLifecycleOwner,
                {list -> list.body()?.let { adapter.setList(it) }
                })
            Toast.makeText(requireContext(), "Refreshed", Toast.LENGTH_LONG).show()
        }
    }

}