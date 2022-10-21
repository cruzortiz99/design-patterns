package design.pattern.kotlin.patterns.creational.abstract_factory_method

class FordFactory : VehicleFactory {
    override fun createDeportCar(): DeportVehicle {
        return FordMustang()
    }

    override fun createRusticCar(): RusticVehicle {
        return FordPickup()
    }
}