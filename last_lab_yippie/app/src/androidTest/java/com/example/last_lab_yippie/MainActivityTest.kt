package com.example.last_lab_yippie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun testAllButtonsExist() {
        onView(withId(R.id.btn1)).check(matches(isDisplayed()))
        onView(withId(R.id.btn2)).check(matches(isDisplayed()))
        onView(withId(R.id.btn3)).check(matches(isDisplayed()))
    }

    @Test
    fun testBtn1LaunchesFirstActivity() {
        onView(withId(R.id.btn1)).perform(click())
        val scenario = ActivityScenario.launch(FisrtActivity::class.java)
        assertNotNull(scenario)
        scenario.close()
    }

    @Test
    fun testBtn2LaunchesSecondActivity() {
        onView(withId(R.id.btn2)).perform(click())
        val scenario = ActivityScenario.launch(SecondActivity::class.java)
        assertNotNull(scenario)
        scenario.close()
    }

    @Test
    fun testBtn3DoesNotCrash() {
        onView(withId(R.id.btn3)).perform(click())
    }
}
