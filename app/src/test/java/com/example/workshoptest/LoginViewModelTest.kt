package com.example.workshoptest

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    /**
     *regra para realizar tarefas sincronas
     */
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    lateinit var viewModel: LoginViewlModel
    lateinit var isLoginLiveData: LiveData<Boolean>

    @Before
    fun setUp() {
        val repository = mock<LoginRepository>()
        viewModel = LoginViewlModel(repository, CoroutineProviderTest())
        isLoginLiveData = MutableLiveData<Boolean>()

    }

   /* @Test
    fun givenValidRegistration_whenValidate_shouldReturnLiveDataTrue() {

        validateLogin("ana.silva@gmail.com", "1234567A.b")?.let { Assert.assertTrue(it) }


    }*/

    @Test
    fun givenInValidPassword_whenValidate_shouldReturnLiveDataFalse() {
        validateLogin("ana.silva@gmail.com", "123")?.let { Assert.assertFalse(it) }


    }

    @Test
    fun givenInValidEmail_whenValidate_shouldReturnLiveDataFalse() {
        validateLogin("ana.silvagmail.com", "1234567A.b")?.let { Assert.assertFalse(it) }


    }

    fun validateLogin(email: String, password: String): Boolean? {
        isLoginLiveData = viewModel.validate(email, password)
        return isLoginLiveData.value

    }

}