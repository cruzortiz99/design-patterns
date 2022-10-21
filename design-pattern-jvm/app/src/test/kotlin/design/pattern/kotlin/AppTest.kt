package design.pattern.kotlin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull

internal class AppTest {
    @Test
    fun appHasAGreeting() {
        assertNotNull(greeting(), "app should have a greeting")
    }

    @Test
    fun itShouldBldMapWithRightValuesWhenMakeMapIsCalledWithStrs() {
        val mappedParams: Map<String, String> = makeMapProperties("-Pname=cruz", "-Ptest=one")
        Assertions.assertEquals(mappedParams["name"] ?: "", "cruz")
        Assertions.assertEquals(mappedParams["test"] ?: "", "one")
    }

    @Test
    fun itShouldAvoidBadParamStructureWhenIsCalledWithStrs() {
        val mappedParams = makeMapProperties("name=cruz", "-test=one", "-Ptesttwo")
        Assertions.assertTrue(mappedParams.isEmpty())
    }
}