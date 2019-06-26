package com.example.workshoptest

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers

fun registerAction(func : RegisterRobot.RegisterActions.() -> Unit) = RegisterRobot.RegisterActions().apply(func)
fun registerAssert (registerAssert : RegisterRobot.RegisterAssert.() -> Unit) = RegisterRobot.RegisterAssert().apply(registerAssert)
class RegisterRobot {

    class RegisterActions(){

        fun hideKeyboard(){
            Espresso.closeSoftKeyboard()
        }

        fun setName(name : String){
            Espresso.onView(ViewMatchers.withId(R.id.txt_edit_name))
                .perform(ViewActions.typeText(name))
        }

        fun setEmail(email : String) {
            Espresso.onView(ViewMatchers.withId(R.id.txt_edit_email))
                .perform(ViewActions.typeText(email))
        }

        fun setCpf(cpf : String) {
            Espresso.onView(ViewMatchers.withId(R.id.txt_edit_cpf))
                .perform(ViewActions.typeText(cpf))
        }
        fun setPassword(password : String) {
            Espresso.onView(ViewMatchers.withId(R.id.txt_edit_password))
                .perform(ViewActions.typeText(password))
        }
        fun clickButtonRegister(){
            Espresso.onView(ViewMatchers.withId(R.id.btn_register))
                .perform(ViewActions.click())
        }
    }

    class RegisterAssert {

        fun showMessageRegisterSucess(){
            Espresso.onView(ViewMatchers.withText(R.string.successful_registration))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }

        fun showMessageError(messageError : String) {
                   Espresso.onView(ViewMatchers.withText(messageError))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }
}