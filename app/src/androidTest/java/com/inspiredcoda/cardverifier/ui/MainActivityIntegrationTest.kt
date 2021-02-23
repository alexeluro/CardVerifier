package com.inspiredcoda.cardverifier.ui

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.inspiredcoda.cardverifier.R
import org.junit.After
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityIntegrationTest {

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity>? =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCardVerificationProcess() {

        // Type in the sample card serial number
        Espresso.onView(withId(R.id.main_serial_input))
            .perform(typeText("457133496"), closeSoftKeyboard())
            .check(ViewAssertions.matches(withText("4571 3349 6")))

    }

    @After
    fun tearDown(){
        activityScenarioRule = null
    }

}