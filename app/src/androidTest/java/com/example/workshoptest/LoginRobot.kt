package com.example.workshoptest

import android.app.Activity
import android.app.Instrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers
import com.example.workshoptest.view.activity.MainActivity

import org.hamcrest.CoreMatchers


fun loginArrange(loginArrange: LoginRobot.LoginArrange.() -> Unit) = LoginRobot.LoginArrange().apply { loginArrange() }
fun loginAction(loginActions: LoginRobot.LoginActions.() -> Unit) = LoginRobot.LoginActions().apply { loginActions() }
fun loginAssert(loginAssert: LoginRobot.LoginAssert.() -> Unit) = LoginRobot.LoginAssert().apply { loginAssert() }


class LoginRobot() {

    class LoginArrange() {
        fun mockMainActivity() {
            val mainActivityIntent = IntentMatchers.hasComponent(MainActivity::class.java.name)
            Intents.intending(mainActivityIntent)
                .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))

        }
    }

    class LoginActions() {
        fun setPassword(password: String) {
            onView(ViewMatchers.withId(R.id.tv_password))
                .perform(ViewActions.typeText(password))
        }

        fun setEmail(email: String) {
            onView(ViewMatchers.withId(R.id.tv_email))
                .perform(ViewActions.typeText(email))
        }

        fun clickLogin() {
            onView(ViewMatchers.withId(R.id.btn_login)).perform(click())
        }
    }

    class LoginAssert {
        fun loginSucess() {
           // Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name), Intents.times(0))
            Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name), Intents.times(0))

        }

        fun loginError() {
            onView(
                CoreMatchers.allOf(
                    ViewMatchers.withText(R.string.login_error),
                    ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.txt_password))
                )
            ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        }
    }
}