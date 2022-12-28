package com.example.mycourseapp.data.repository

import com.example.mycourseapp.data.api.RetrofitInstance
import com.example.mycourseapp.model.cash.CashModel
import com.example.mycourseapp.model.cash.CashModelItem
import com.example.mycourseapp.model.non_cash.NonCashModel
import com.example.mycourseapp.model.non_cash.NonCashModelItem
import retrofit2.Response

class Repository {
    suspend fun getCash(): Response<CashModel>{
        return RetrofitInstance.api.getCashMoney()
    }

    suspend fun getNonCash(): Response<NonCashModel>{
        return RetrofitInstance.api.getNonCashMoney()
    }
}