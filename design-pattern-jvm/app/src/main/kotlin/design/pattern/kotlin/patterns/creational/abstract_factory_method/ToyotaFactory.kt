package design.pattern.kotlin.patterns.creational.abstract_factory_method

class ToyotaFactory : VehicleFactory {
    override fun createDeportCar(): DeportVehicle {
        return ToyotaYaris()
    }

    override fun createRusticCar(): RusticVehicle {
        return ToyotaForRunner()
    }
}