package com.example.workshoptest.util


import java.util.regex.Pattern

object ValidatorCpf {


    fun validatorCpf(cpf: String): Boolean {
        return !Pattern.compile("([0-9]{3}[\$.]?[0-9]{3}[\$.]?[0-9]{3}[-]?[0-9]{2})").matcher(
            cpf
        ).matches()
    }

    fun regexEmail(email: String): Boolean {
        return !Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        ).matcher(email).matches()
    }

}




