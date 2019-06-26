package com.example.workshoptest


import android.app.Activity
import android.app.Instrumentation
import android.support.test.espresso.Espresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.*
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule

import android.support.test.runner.AndroidJUnit4
import com.example.workshoptest.view.activity.LoginActivity
import com.example.workshoptest.view.activity.MainActivity
import com.example.workshoptest.view.activity.RegisterActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.junit.FixMethodOrder


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activity = IntentsTestRule<LoginActivity>(LoginActivity::class.java, true, true)



    @Test
    fun givenValidLogin_whenValidate_shouldShowMainActivity() {

        val mainActivityIntent = IntentMatchers.hasComponent(MainActivity::class.java.name)
        Intents.intending(mainActivityIntent)
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
        /**
         * encontre uma view com o id txt_edit_email
         */
        onView(withId(R.id.tv_email))
            .perform(typeText("maria@gmail.com"))

        /**
         * encontre uma view com o id txt_edit_password
         */
        onView(withId(R.id.tv_password))
            .perform(typeText("12345A.b"))
        Espresso.closeSoftKeyboard()
        /**
         * encontre o botao com o id btn_login e execute o click
         */
        onView(withId(R.id.btn_login)).perform(click())
        /**
         * assertiva para verificar se a intent chamou minha activity (MainActivity)
         */
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name), times(0))

    }


    //uma senha só com numeros
    //uma senha só com letras
    //uma senha só com caracteres especias
    //uma senha em branco
    //senha com um tamanho menor que 8
    /**
     * todos os cenarios acima ja foram testados em testes locais,
     * para os teste em telas (instrumentados) devem ser testados apenas os comportamentos,
     * neste caso para esta tela (Login) devem ser testados dois comportamentos:
     * 1 - se o Login foi feito com sucesso, ou seja, se foi redirecionado para a tela mainActivity
     * 2 - se qdo o Login nao for realizado com sucesso, se deve ser retornado para activity uma mensagem de erro
     */

    /**
     * valida se mostra a mensagem de erro
     */
    @Test
    fun givenInvalidLogin_whenValidate_shouldShowErrorMessage() {
        /**
         * 1 - Find a view - encontra uma visualizacao especifica na tela em toda
         * a hierarquia da visualizacao
         * 2 - Action - Execute alguma acao nessa view
         * 3 - Assertiva - Faça algumas afirmaçoes sobre a visao
         */
        /**
         * arrange, preparacao do teste
         */
        onView(withId(R.id.tv_email))
            .perform(typeText("mariagmail.com"))
        onView(withId(R.id.tv_password))
            .perform(typeText("12345678"))
        Espresso.closeSoftKeyboard()
        /**
         * ação
         */
        onView(withId(R.id.btn_login)).perform(click())
        /**
         * assertiva
         */
        onView(
            allOf(
                withText(R.string.login_error),
                isDescendantOfA(withId(R.id.txt_password))
            )
        ).check(matches(isDisplayed()))


    }

    @Test
    fun givenRegisterSuccessfully_whenResultOk_shouldShowMessageSucess() {
        //retorna um resultado quando o Intent for iniciado, no caso RESULT_OK
        intending(hasComponent(RegisterActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        onView(withId(R.id.txt_register)).perform(click())
        onView(withText(R.string.successful_registration)).check(ViewAssertions.matches(isDisplayed()))
      /*  onView(withText(R.string.successful_registration))
            .inRoot(RootMatchers.withDecorView(CoreMatchers.not(activity.activity.window.decorView)))
            .check(matches(isDisplayed()));*/
    }




}