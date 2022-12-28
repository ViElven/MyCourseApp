package com.example.mycourseapp.screens.cash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycourseapp.data.repository.Repository
import com.example.mycourseapp.model.cash.CashModel
import kotlinx.coroutines.launch
import retrofit2.Response

class CashViewModel: ViewModel() {
    var repo = Repository()
    val myMoneyList: MutableLiveData<Response<CashModel>> = MutableLiveData()

    fun getCashMoney(){
        viewModelScope.launch {
            myMoneyList.value = repo.getCash()
        }
    }
}