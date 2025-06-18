package com.example.a18_06

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButton1Exists() {
        onView(withId(R.id.btn1)).check(matches(isDisplayed()))
    }

    @Test
    fun testButtonCorrectText() {
        onView(withId(R.id.btn1)).check(matches(withText("Активити 1")))
    }

    @Test
    fun testIntentTransition() {
        onView(withId(R.id.btn1)).perform(click())
        val scenario = ActivityScenario.launch(FirstActivity::class.java)
        assertNotNull(scenario)
        scenario.close()
    }

}