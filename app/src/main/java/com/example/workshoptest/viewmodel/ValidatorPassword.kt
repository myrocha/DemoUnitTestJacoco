package com.example.workshoptest.viewmodel


object ValidatorPassword {

    private const val LENGTH_PASSWORD = 8
    fun validatePassword(pass: String): Boolean {

        if (!pass.contains(Regex("[A-Z]"))) {
            return false
        }
        if (!pass.contains(Regex("[a-z]"))) {
            return false
        }

        if (!pass.contains(Regex("[0-9]"))) {
            return false
        }

        if (!pass.contains(Regex("[^A-Za-z0-9]"))) {
            return false
        }
        return pass.length >= LENGTH_PASSWORD
    }
}




