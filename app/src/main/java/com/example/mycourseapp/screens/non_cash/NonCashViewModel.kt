package com.example.mycourseapp.screens.non_cash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseapp.data.repository.Repository
import com.example.mycourseapp.model.non_cash.NonCashModel
import kotlinx.coroutines.launch
import retrofit2.Response

class NonCashViewModel: ViewModel() {

    var repo = Repository()
    val myMoneyList: MutableLiveData<Response<NonCashModel>> = MutableLiveData()

    fun getNonCashMoney(){
        viewModelScope.launch {
            myMoneyList.value = repo.getNonCash()
        }
    }
}