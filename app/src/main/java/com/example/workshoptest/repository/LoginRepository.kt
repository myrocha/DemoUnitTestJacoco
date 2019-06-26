package com.example.workshoptest.repository

import com.example.workshoptest.model.Login

import com.example.workshoptest.service.LoginService


class LoginRepository constructor(private val api: LoginService) {
    fun getLogin(user: Login) =
        api.login(user)
}