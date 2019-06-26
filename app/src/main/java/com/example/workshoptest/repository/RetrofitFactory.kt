package com.example.workshoptest.repository

import com.example.workshoptest.service.LoginService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    private const val TIMEOUT_MINUTES = 1L
    private const val TIMEOUT_SECONDS = 30L

    private val retrofit = Retrofit.Builder().baseUrl("http://10.27.164.61:3000/api/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(
            OkHttpClient().newBuilder()
                .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS).build()
        ).addConverterFactory(GsonConverterFactory.create()).build()

    fun login(): LoginService {
        return retrofit.create(LoginService::class.java)
    }
}

