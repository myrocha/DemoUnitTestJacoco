package com.example.workshoptest

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.workshoptest.view.activity.RegisterActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterActivityTestv2 {

    @get:Rule
    val activity = ActivityTestRule(RegisterActivity::class.java)

    @Test
    fun givenValidateRegistration_whenValidatorRegister_shouldShowMessageSuccessful() {
        registerAction {
            hideKeyboard()
            setName("Joana")
            setCpf("98622275614")
            setEmail("joana@gmail.com")
            hideKeyboard()
            setPassword("1234567A.b")
            hideKeyboard()
            clickButtonRegister()
        }
        registerAssert {
            showMessageRegisterSucess()
        }
    }

    @Test
    fun givenIvalidName_whenValidatorRegister_shouldMessageInvalidName() {
        registerAction {
            hideKeyboard()
            setName("")
            hideKeyboard()
            clickButtonRegister()
        }
        registerAssert {
            showMessageError("Nome inválido.")
        }
    }

    @Test
    fun givenInvalidCpf_whenValidatorRegister_shouldMessageInvalidCpf() {
        registerAction {
            hideKeyboard()
            setName("Ana")
            setCpf("1234")
            hideKeyboard()
            clickButtonRegister()
        }
        registerAssert {
            showMessageError("Cpf inválido.")
        }
    }
    @Test
    fun givenInvalidEmail_whenValidorRegister_shouldMessageInvalidEmail(){
        registerAction {
            hideKeyboard()
            setName("Ana")
            setCpf("98621468311")
            setEmail("emailInvalido.com.br")
            hideKeyboard()
            clickButtonRegister()
        }
        registerAssert {
            showMessageError("E-mail inválido.")
        }
    }

    @Test
    fun givenInvalidPassword_whenValidRegister_shouldMessageInvalidPassword(){
        registerAction {
            hideKeyboard()
            setName("Ana")
            setCpf("98425555514")
            setEmail("ana@gmail.com")
            hideKeyboard()
            setPassword("123456A")
            hideKeyboard()
            clickButtonRegister()
        }
        registerAssert {
            showMessageError("A senha deve ter no mínimo 8 caracteres, uma letra maiscula, uma letra minuscula e um caracter especial.")
        }
    }
}