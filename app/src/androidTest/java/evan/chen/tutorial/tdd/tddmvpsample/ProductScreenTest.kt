package evan.chen.tutorial.tdd.tddmvpsample

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ProductScreenTest {
    @get:Rule
    var activityActivityTestRule = ActivityTestRule(ProductActivity::class.java, true, false)

    @Test
    fun productViewTest() {

        val intent = Intent()

        activityActivityTestRule.launchActivity(intent)

        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.productName))
            .check(ViewAssertions.matches(ViewMatchers.withText("Google Pixel 3")))
    }
}
