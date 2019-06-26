package com.example.workshoptest

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.workshoptest.view.activity.RegisterActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.R.attr.data



@RunWith(AndroidJUnit4::class)
class RegisterActivityTest {

    @get:Rule
    val activity = ActivityTestRule(RegisterActivity::class.java)

    @Test
    fun givenValidRegistration_whenValidatorRegister_shouldShowMessageSuccessful() {
       // val result = Instrumentation.ActivityResult(Activity.RESULT_OK, data))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_name))
            .perform(ViewActions.typeText("Joana"))
        onView(ViewMatchers.withId(R.id.txt_edit_cpf))
            .perform(ViewActions.typeText("98523171215"))
        onView(ViewMatchers.withId(R.id.txt_edit_email))
            .perform(ViewActions.typeText("joana@gmail.com"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_password))
            .perform(ViewActions.typeText("12345A.b"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())

        /*onView(withText(R.string.successful_registration))
            .inRoot(withDecorView(not(activity.activity.window.decorView)))
            .check(matches(isDisplayed()));*/
       onView(withText(R.string.successful_registration)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun givenInvalidName_whenValidateRegister_shouldShowMessageInvalidName() {
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_name))
            .perform(ViewActions.typeText(""))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())
        onView(withText(R.string.error_name)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun givenInvalidCpf_whenValidateRegister_shouldShowMessageInvalidCpf() {
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_name))
            .perform(ViewActions.typeText("Ana"))
        onView(ViewMatchers.withId(R.id.txt_edit_cpf))
            .perform(ViewActions.typeText("1234"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())
        onView(withText(R.string.error_cpf)).check(matches(isDisplayed()))
    }

    @Test
    fun givenInvalidEmail_whenValidateRegister_shouldMessageInvalidEmail(){
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_name))
            .perform(ViewActions.typeText("Ana"))
        onView(ViewMatchers.withId(R.id.txt_edit_cpf))
            .perform(ViewActions.typeText("98425555514"))
        onView(ViewMatchers.withId(R.id.txt_edit_email))
            .perform(ViewActions.typeText("ana@gmailcom"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())
        onView(withText(R.string.error_email)).check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordInvalid_whenValidateRegister_shouldMessagePasswordInvalid(){
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_name))
            .perform(ViewActions.typeText("Ana"))
        onView(ViewMatchers.withId(R.id.txt_edit_cpf))
            .perform(ViewActions.typeText("98425555514"))
        onView(ViewMatchers.withId(R.id.txt_edit_email))
            .perform(ViewActions.typeText("ana@gmail.com"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.txt_edit_password))
            .perform(ViewActions.typeText("123456A"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click())

        onView(withText(R.string.error_password)).check(matches(isDisplayed()))
    }


}