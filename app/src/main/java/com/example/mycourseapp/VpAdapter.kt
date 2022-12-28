package com.example.mycourseapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mycourseapp.screens.cash.CashFragment
import com.example.mycourseapp.screens.non_cash.NonCashFragment

class VpAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CashFragment()
            else -> NonCashFragment()
        }
    }

}