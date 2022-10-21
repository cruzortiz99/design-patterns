package design.pattern.kotlin.patterns.creational.prototype

interface CarPrototype {
    fun copy(): CarPrototype?
}