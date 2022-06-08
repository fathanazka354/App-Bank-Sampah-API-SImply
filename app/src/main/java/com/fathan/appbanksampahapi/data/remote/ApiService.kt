package com.fathan.appbanksampahapi.data.remote

import com.fathan.appbanksampahapi.data.response.BankSampahResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    fun getDataBankSampah(
    ): Call<BankSampahResponse>
}