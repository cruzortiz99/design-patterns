package design.pattern.kotlin.patterns.creational.factory_method

class BigCarFactory : CarFactory {
    override fun produceCar(): Car {
        return BigCar()
    }
}