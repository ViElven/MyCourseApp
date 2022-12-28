package com.example.mycourseapp.data.api

import com.example.mycourseapp.model.cash.CashModel
import com.example.mycourseapp.model.cash.CashModelItem
import com.example.mycourseapp.model.non_cash.NonCashModel
import com.example.mycourseapp.model.non_cash.NonCashModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCashMoney(): Response<CashModel>

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getNonCashMoney():Response<NonCashModel>


}