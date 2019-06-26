package com.example.workshoptest.viewmodel

import com.example.workshoptest.util.ValidatorCpf

object ValidatorRegister {
    fun validateName(name: String): Boolean {
        var result = !(name.isNullOrEmpty() || name.isBlank() || name == "null")
        return result

    }

    fun validateCpf(cpf: String): Boolean {
        return !(cpf.isNullOrEmpty() || cpf.isBlank() || ValidatorCpf.validatorCpf(cpf))

    }

    fun validateEmail(email: String): Boolean {
        return !(email.isNullOrEmpty() || email.isBlank() || ValidatorCpf.regexEmail(email))
    }


}
