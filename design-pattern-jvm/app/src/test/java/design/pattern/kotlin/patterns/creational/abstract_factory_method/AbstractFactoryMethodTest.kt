package design.pattern.kotlin.patterns.creational.abstract_factory_method

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AbstractFactoryMethodTest {
    @Test
    fun itShouldCreateFordMustangWhenIsRequestedFromFordFactory() {
        val factory:VehicleFactory = FordFactory()
        val car = factory.createDeportCar()
        Assertions.assertTrue(car is FordMustang)
    }

    @Test
    fun itShouldCreateFordPickUpWhenIsRequestedFromFordFactory() {
        val factory: VehicleFactory = FordFactory()
        val car = factory.createRusticCar()
        Assertions.assertTrue(car is FordPickup)
    }

    @Test
    fun itShouldCreateToyotaYarisWhenIsRequestedFromToyotaFactory() {
        val factory: VehicleFactory = ToyotaFactory()
        val car = factory.createDeportCar()
        Assertions.assertTrue(car is ToyotaYaris)
    }

    @Test
    fun itShouldCreateForRunnerWhenIsRequestedFromToyotaFactory() {
        val factory: VehicleFactory = ToyotaFactory()
        val car = factory.createRusticCar()
        Assertions.assertTrue(car is ToyotaForRunner)
    }
}