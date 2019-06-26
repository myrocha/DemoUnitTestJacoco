package com.example.workshoptest


import com.example.workshoptest.viewmodel.ValidatorPassword

import org.junit.Test

import org.junit.Assert.*



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PasswordValidatorTest {


    @Test
    fun givenValidPassword_whenValidate_shouldReturnTrue() {
        val password = "Ab.c45678"
        assertTrue(validate(password))
    }

    @Test
    fun givenPasswordWithLength7_whenValidate_shouldReturnFalse() {
        val password = "1234567"
        assertFalse(validate(password))
    }

    @Test
    fun givenPasswordWithCapital_whenValidateLatterCapital_shouldReturnFalse() {
        val password = "1234567A"
        assertFalse(validate(password))


    }

    @Test
    fun givenPasswordWithLowercase_whenValidateLowerCase_shouldReturnFalse() {
        var password = "1234567a"
        assertFalse(validate(password))

    }

    @Test
    fun givenPasswordWithSpecialCharacter_whenSpecialCharacter_shouldReturnFalse() {
        var password = "1234567#"
        assertFalse(validate(password))

    }

    @Test
    fun givenPasswordWithNumber_whenValidateNumber_shouldReturnFalse() {
        var password = "123456789"
        assertFalse(validate(password))

    }

    @Test
    fun givenPasswordOnlyLetter_whenValidateLatterCapital_shouldReturnFalse() {
        val password = "abcdeF"
        assertFalse(validate(password))
    }

    @Test
    fun givenPasswordOnlySpecialCharacter_whenValidateLatterCapital_shouldReturnFalse() {
        val password = "Abc45678"
        assertFalse(validate(password))
    }

    private fun validate(password: String): Boolean {
        return ValidatorPassword.validatePassword(password)
    }




}
