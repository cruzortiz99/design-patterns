package design.pattern.kotlin.patterns.creational.abstract_factory_method

interface VehicleFactory {
    fun createDeportCar(): DeportVehicle
    fun createRusticCar(): RusticVehicle
}