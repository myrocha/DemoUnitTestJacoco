package com.example.workshoptest.repository

import com.example.workshoptest.model.entity.User
import com.example.workshoptest.model.persistence.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async

class MainRepository (val userDao: UserDao) {

     fun getAllUsers()  /*List<User>*/{
      /*  return scope.async {
            userDao.getAll()
        }.await()*/

    }

}