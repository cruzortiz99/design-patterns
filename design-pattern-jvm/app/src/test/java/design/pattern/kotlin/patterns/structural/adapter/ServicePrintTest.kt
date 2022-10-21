package design.pattern.kotlin.patterns.structural.adapter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ServicePrintTest {
    @Test
    fun itShouldReturnStringWithExtendedMessageWhenServiceIsCalled() {
        val input = "some test"
        val service = ServicePrintString()
        val result = service.apply(input)
        Assertions.assertNotEquals(input, result)
        Assertions.assertTrue(result.endsWith(input))
    }

    @Test
    fun itShouldReturnStringWithMessageWhenAdapterIsCalled() {
        val input = 345
        val serviceAdapted = AdapterIntToString(
            ServicePrintString()
        )
        val result = serviceAdapted.apply(input)
        Assertions.assertNotEquals(input.toString(), result)
        Assertions.assertTrue(result.endsWith(input.toString()))
    }
}