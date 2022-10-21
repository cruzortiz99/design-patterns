package design.pattern.kotlin.patterns.creational.prototype

import design.pattern.java.patterns.creational.prototype.CarPrototype

class Car(var name: String) : CarPrototype {
    override fun copy(): CarPrototype {
        return Car(name)
    }
}