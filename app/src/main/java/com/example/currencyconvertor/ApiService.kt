package com.example.currencyconvertor

import com.example.currencyconvertor.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("json/")
    fun getAllCurrency(): Call<List<Currency>>

    @GET("json/{id}")
    fun getCurrency(@Query("id") userId: Int): Call<Currency>
}