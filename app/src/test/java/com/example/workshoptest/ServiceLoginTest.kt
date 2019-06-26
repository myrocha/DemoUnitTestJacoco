package com.example.workshoptest

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.*
import com.example.workshoptest.model.UserResponse
import com.example.workshoptest.repository.LoginRepository
import com.example.workshoptest.service.LoginService
import com.example.workshoptest.viewmodel.LoginViewlModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

fun <T> T.toDeferred() = GlobalScope.async { this@toDeferred }

class ServiceLoginTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    lateinit var loginViewlModel: LoginViewlModel
    lateinit var loginRepository: LoginRepository
    lateinit var isLoginLiveData: LiveData<UserResponse>


  /*  val userResponse = UserResponse(
        1,
        "Ana",
        "ana.silva@gmail.com",
        "98676554321",
        "ygt3tfdc3td3f62r256r6r6r62G6FV@##Byvcy4778"
    )*/

    @Mock
    lateinit var apiMock: LoginService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        loginRepository = LoginRepository(apiMock)
        loginViewlModel = LoginViewlModel(loginRepository, CoroutineProviderTest())
        isLoginLiveData = MutableLiveData<UserResponse>()
    }


    //@Test
    /*fun givenLoginValid_whenValid_shouldReturnUserValid() = runBlocking {
        whenever(apiMock.login(any())).thenReturn(userResponse.toDeferred())
        val response = loginViewlModel.getLogin()
        Assert.assertEquals(userResponse, response.value)
    }*/
}