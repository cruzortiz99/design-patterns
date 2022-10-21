package design.pattern.kotlin.patterns.creational.factory_method

class SmallCarFactory : CarFactory {
    override fun produceCar(): Car {
        return SmallCar()
    }
}