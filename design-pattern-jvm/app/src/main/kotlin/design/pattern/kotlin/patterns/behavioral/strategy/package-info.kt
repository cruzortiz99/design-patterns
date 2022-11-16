package design.pattern.kotlin.patterns.behavioral.strategy

typealias RouteBuilder = () -> String

fun BikeStrategy(): String {
  return "Bike route"
}

fun CarStrategy(): String {
  return "Car route"
}

fun AirplaneStrategy(): String {
  return "Airplane route"
}

fun WalkerStrategy(): String {
  return "Walker route"
}

class Map(var strategy: RouteBuilder) {
  fun createRoute(): String = this.strategy()

  fun changeStrategy(newStrategy: RouteBuilder): Map {
    this.strategy = newStrategy
    return this
  }
}
