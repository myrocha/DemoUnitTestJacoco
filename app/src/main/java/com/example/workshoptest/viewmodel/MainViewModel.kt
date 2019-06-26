package com.example.workshoptest.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.workshoptest.coroutine.CoroutineProvider
import com.example.workshoptest.model.entity.User
import com.example.workshoptest.repository.MainRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel (repository: MainRepository, coroutineProvider: CoroutineProvider) : BaseViewModel(coroutineProvider) {

    private val mainRepository = repository
    private val listUser = MutableLiveData<List<User>>()

    fun getAllUsers() : LiveData<List<User>>{
        launch {
            //listUser.value = mainRepository.getAllUsers()
        }
        return listUser


    }

}