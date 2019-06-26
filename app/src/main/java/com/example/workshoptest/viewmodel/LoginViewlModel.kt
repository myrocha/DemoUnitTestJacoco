package com.example.workshoptest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.coroutine.CoroutineProvider
import com.example.workshoptest.model.UserResponse
import com.example.workshoptest.model.Login

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException as HttpException1


class LoginViewlModel constructor(repository: LoginRepository, coroutineProvider: CoroutineProvider) :
    BaseViewModel(coroutineProvider) {
    /**
     * para injecao de independencia : koin
     */

    private val isLogin = MutableLiveData<Boolean>()
    private val users: MutableLiveData<UserResponse> = MutableLiveData()
    private var repository = repository

    fun getLogin(password: String, email: String): LiveData<UserResponse> {

        val login = getObjectLogin(password, email)

        launch {
                val userResponse = repository.getLogin(login).await()
                users.value = userResponse
              //  val us = UserResponse(1, "ana", "ana@gmail.com", "9876543")
        }
        return users
    }

    private fun getObjectLogin(password: String, email: String) : Login{
        var login = Login(password, email)
        /*login.email = email
        login.password = password*/
        return login
    }


    fun validate(password : String, email : String): LiveData<Boolean> {
        when {
            !ValidatorPassword.validatePassword(password) -> {
                isLogin.value = false
            }
            !ValidatorRegister.validateEmail(email) -> {
                isLogin.value = false
            }
            else -> {
                isLogin.value = true
            }
        }
        return isLogin
    }

}