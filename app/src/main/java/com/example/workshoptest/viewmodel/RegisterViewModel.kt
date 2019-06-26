package com.example.workshoptest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.workshoptest.constants.Constants
import com.example.workshoptest.coroutine.CoroutineProvider
import com.example.workshoptest.model.entity.User
import com.example.workshoptest.repository.RegisterRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class RegisterViewModel constructor(repository: RegisterRepository, coroutineProvider: CoroutineProvider) :
    BaseViewModel(coroutineProvider) {
    private val registerRepository = repository
    private val resultRegister = MutableLiveData<Int>()
    private val saveRegister = MutableLiveData<Int>()

    fun onRegister(name: String, cpf: String, email: String, password: String): LiveData<Int> {

        when {
            !ValidatorRegister.validateName(name) -> {
                resultRegister.value = Constants.INVALID_NAME
            }
            !ValidatorRegister.validateCpf(cpf) -> {
                resultRegister.value = Constants.INVALID_CPF
            }
            !ValidatorRegister.validateEmail(email) -> {
                resultRegister.value = Constants.INVALID_EMAIL
            }
            !ValidatorPassword.validatePassword(password) -> {
                resultRegister.value = Constants.INVALID_PASSWORD
            }
            else -> {
                resultRegister.value = Constants.SUCCESS_REGISTRATION
            }
        }
        return resultRegister
    }


    fun saveUser(name: String, cpf: String, email: String, password: String): LiveData<Int> {

        launch {
            val user = User(0, name, email, cpf, "12sd32d22")
            saveRegister.value = registerRepository.saveUser(user).toInt()
        }

        return saveRegister
    }


}