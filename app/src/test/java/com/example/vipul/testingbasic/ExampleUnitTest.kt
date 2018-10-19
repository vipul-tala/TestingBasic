package com.example.vipul.testingbasic

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "../app/src/main/AndroidManifest.xml")
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        RuntimeEnvironment.application.resources.getColor(R.color.vipul);
        assertEquals(4, 2 + 2)
    }
}
