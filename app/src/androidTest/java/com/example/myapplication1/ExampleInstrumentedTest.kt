package com.example.myapplication1

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCurrencyConversion() {

        Espresso.onView(withId(R.id.amountEditText)).perform(ViewActions.typeText("100"))


        Espresso.onView(withId(R.id.fromCurrencySpinner)).perform(ViewActions.click())
        Espresso.onView(withText("USD")).perform(ViewActions.click())


        Espresso.onView(withId(R.id.toCurrencySpinner)).perform(ViewActions.click())
        Espresso.onView(withText("EUR")).perform(ViewActions.click())


        Espresso.onView(withId(R.id.convertButton)).perform(ViewActions.click())


        Espresso.onView(withId(R.id.resultTextView))
            .check(ViewAssertions.matches(withText("Ответ: 92.00 EUR")))
    }

    @Test
    fun testInvalidCurrencyConversion() {

        Espresso.onView(withId(R.id.amountEditText)).perform(ViewActions.typeText("100"))


        Espresso.onView(withId(R.id.fromCurrencySpinner)).perform(ViewActions.click())
        Espresso.onView(withText("USD")).perform(ViewActions.click())


        Espresso.onView(withId(R.id.toCurrencySpinner)).perform(ViewActions.click())
        Espresso.onView(withText("RUB")).perform(ViewActions.click())


        Espresso.onView(withId(R.id.convertButton)).perform(ViewActions.click())


        Espresso.onView(withId(R.id.resultTextView))
            .check(ViewAssertions.matches(withText("Ответ: 8500.00 RUB")))
    }
}