package com.fathan.appbanksampahapi.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fathan.appbanksampahapi.data.response.BankSampahResponse
import com.fathan.appbanksampahapi.data.response.ListBankSampah
import com.fathan.appbanksampahapi.data.remote.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    val listBankSampah= MutableLiveData<ArrayList<ListBankSampah>>()

    fun getBankSampah(){
        ApiConfig.getApiService().getDataBankSampah().enqueue(object : Callback<BankSampahResponse> {
            override fun onResponse(
                call: Call<BankSampahResponse>,
                response: Response<BankSampahResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        listBankSampah.postValue(responseBody.data)
                        Log.d(TAG, "onResponseSuccess: ${responseBody.data}")
                    }
                } else {
                    Log.d(TAG, "onResponseNotSuccess: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BankSampahResponse>, t: Throwable) {
                Log.d(TAG, "onResponse: ${t.message}")
            }
        })
    }
    fun getListAll():LiveData<ArrayList<ListBankSampah>>{
        return listBankSampah
    }
    companion object{
        val TAG = "BankSampahRepository"
    }
}