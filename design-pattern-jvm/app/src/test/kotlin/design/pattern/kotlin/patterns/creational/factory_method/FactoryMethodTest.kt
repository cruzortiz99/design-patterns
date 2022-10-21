package design.pattern.kotlin.patterns.creational.factory_method

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FactoryMethodTestKt {
    @Test
    fun itShouldCreateSmallCarInstanceWhenSmallCarFactoryIsUsed() {
        val factory: CarFactory = SmallCarFactory()
        val car = factory.produceCar()
        Assertions.assertTrue(car is SmallCar)
    }

    @Test
    fun itShouldCreateBigCarInstanceWhenBigCarFactoryIsUsed() {
        val factory: CarFactory = BigCarFactory()
        val car = factory.produceCar()
        Assertions.assertTrue(car is BigCar)
    }
}
