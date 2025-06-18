package com.example.last_lab_yippie

import android.graphics.Color
import android.os.SystemClock
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondActivityTest {

    @get:Rule
    val activity = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun testButtonChangesToBlueThenGreen() {
        onView(withId(R.id.buttonChangeColor)).perform(click())

        SystemClock.sleep(3500)

        activity.scenario.onActivity { activity ->
            val btn = activity.findViewById<Button>(R.id.buttonChangeColor)
            val tint = btn.backgroundTintList?.defaultColor
            assertNotNull(tint)
            assertEquals(Color.GREEN, tint)
        }
    }
}
