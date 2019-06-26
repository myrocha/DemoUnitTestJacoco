package com.example.workshoptest.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.coroutine.CoroutineProvider
import com.example.workshoptest.viewmodel.LoginViewlModel
import java.lang.IllegalArgumentException

class LoginViewModelFactory constructor(val repository : LoginRepository, val coroutine : CoroutineProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(viewModelClass: Class<T>): T =
        with(viewModelClass) {
            when {
                isAssignableFrom(LoginViewlModel::class.java) ->
                    LoginViewlModel(repository, coroutine)
                else ->
                    throw  IllegalArgumentException("classe desconhecida") as Throwable
            }
        } as T


}


