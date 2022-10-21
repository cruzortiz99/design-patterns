package design.pattern.kotlin.patterns.creational.prototype

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PrototypeTest {
    @Test
    fun shouldCopyValuesWhenCopyIsCalled() {
        val car = Car("test")
        val carCopy = car.copy() as Car
        Assertions.assertEquals(car.name, carCopy.name)
    }

    @Test
    fun shouldHaveDifferentReferenceWhenCopyIsCalled() {
        val car = Car("test")
        val carCopy = car.copy() as Car
        Assertions.assertNotEquals(car, carCopy)
    }
}