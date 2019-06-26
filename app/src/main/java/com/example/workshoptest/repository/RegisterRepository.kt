package com.example.workshoptest.repository

import com.example.workshoptest.model.entity.User
import com.example.workshoptest.model.persistence.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


class RegisterRepository constructor(val userDao: UserDao) {

    suspend fun saveUser(user: User) = withContext(Dispatchers.IO){
        userDao.inserAll(user)
    }


}