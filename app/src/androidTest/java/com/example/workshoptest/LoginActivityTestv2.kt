package com.example.workshoptest
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.workshoptest.view.activity.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTestv2 {
    @Rule
    @JvmField
    val rule = IntentsTestRule<LoginActivity>(LoginActivity::class.java, true, true)

    @Test
    fun givenValidLogin_whenValidate_shouldShouldMainActivity(){
        loginArrange { mockMainActivity() }

        loginAction {
            setEmail("maria@gmail.com")
            setPassword("1234567A.b")
            clickLogin()
        }
        loginAssert { loginSucess() }
    }

    @Test
    fun givenEmailInvalid_whenValidate_shouldShowErrorMessage() {
        loginAction {
            setEmail("mariagmail.com")
            setPassword("12345678A.b")
            clickLogin()
        }
        loginAssert { loginError() }
    }

    @Test
    fun givenPasswordInvalid_whenValidate_shouldErrorMessage(){
        loginAction {
            setEmail("maria@gmail.com")
            setPassword("12345678A")
            clickLogin()
        }
        loginAssert { loginError() }
    }

    @Test
    fun givenPasswordOnlyLetter_whenValidate_shouldErrorMessage(){
        loginAction {
            setEmail("maria@gmail.com")
            setPassword("abcdeF")
            clickLogin()
        }
        loginAssert { loginError() }
    }

    @Test
    fun givenPasswordWithOutSpecialCharacter_whenValidate_shouldErrorMessage(){
        loginAction {
            setEmail("maria@gmail.com")
            setPassword("Abc45678")
            clickLogin()
        }
        loginAssert { loginError() }
    }


}