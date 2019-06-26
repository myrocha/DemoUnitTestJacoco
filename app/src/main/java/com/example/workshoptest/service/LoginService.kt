package com.example.workshoptest.service


import com.example.workshoptest.model.Login
import com.example.workshoptest.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST
import kotlinx.coroutines.Deferred


interface LoginService {
    @POST("login")
    fun login(@Body user : Login):  Deferred<UserResponse>

}