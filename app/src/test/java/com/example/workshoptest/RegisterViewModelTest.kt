package com.example.workshoptest

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.workshoptest.constants.Constants
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.repository.RegisterRepository
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.example.workshoptest.viewmodel.RegisterViewModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RegisterViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    lateinit var viewModel : RegisterViewModel
    lateinit var resultRegisterLiveData : LiveData<Int>

    private val INVALID_NAME = 1
    private val INVALID_EMAIL = 2
    private val INVALID_PASSWORD = 3
    private val SUCCESS_REGISTRATION = 4
    private val INVALID_CPF = 5

    @Before
    fun setUp(){val repository = mock<RegisterRepository>()
        viewModel = RegisterViewModel(repository, CoroutineProviderTest())
        resultRegisterLiveData = MutableLiveData<Int>()
    }

    @Test
    fun givenValidRegister_whenValidateRegister_shouldReturnLiveDataSucessRegistration(){
        resultRegisterLiveData = viewModel.onRegister("Ana", "97634161320", "ana.silva@gmail.com", "1234567A.b")
        Assert.assertEquals(SUCCESS_REGISTRATION, resultRegisterLiveData.value)
    }
    @Test
    fun givenInvalidName_whenValidRegister_shouldReturnLiveDataNameInvalid(){
        resultRegisterLiveData = viewModel.onRegister("", "98523171215", "ana@gmail.com", "123456A.b")
        Assert.assertEquals(INVALID_NAME, resultRegisterLiveData.value)
    }

    @Test
    fun givenInvalidCpf_whenValidRegister_shouldLiveDataCpfInvalid(){
        resultRegisterLiveData = viewModel.onRegister("Ana", "985231", "ana@gmail.com", "12345678A.b")
        Assert.assertEquals(INVALID_CPF, resultRegisterLiveData.value)


    }

    @Test
    fun givenInvalidEmail_whenValidRegister_shouldLiveDataEmailInvalid(){
        resultRegisterLiveData = viewModel.onRegister("Ana", "87623471529", "email.com.com", "123456A.b")
        Assert.assertEquals(INVALID_EMAIL, resultRegisterLiveData.value)
    }

    @Test
    fun givenInvalidPassword_whenValidRegister_shouldLiveDataPasswordInvalid(){
        resultRegisterLiveData = viewModel.onRegister("Ana", "98721312907", "ana@gmail.com", "12345678")
        Assert.assertEquals(INVALID_PASSWORD, resultRegisterLiveData.value)
    }

}