package fr.alainmuller.yamamoto

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import fr.alainmuller.yamamoto.ui.forecast.MainActivity
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(JUnit4::class)
class ExampleInstrumentedTest {

    /**
     *
     * For better testing integration of Screengrab with kotlin,
     * @see https://github.com/csumissu/WeatherForecast/blob/master/app/src/androidTest/java/csumissu/weatherforecast/JUnit4StyleTests.kt
     * or official doc (in Java) :
     * @see https://github.com/fastlane/fastlane/tree/master/screengrab#ui-tests
     *
     */

    @Rule @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    companion object {
        @ClassRule @JvmField
        val localTestRule = LocaleTestRule()

        @BeforeClass @JvmStatic
        fun beforeAll() {
            Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        }
    }

    @Test
    fun testTakeScreenshot() {
        onView(withId(R.id.forecast_list)).check(matches(isDisplayed()))
        Screengrab.screenshot("forecasts")
    }
}
