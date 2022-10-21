package design.pattern.kotlin.patterns.behavioral.mediator

class Airship(private val controlTower: Mediator) {
    fun notifyBeforeLand() {
        controlTower.notify(this, "beforeLand")
    }

    fun notifyAfterLand() {
        controlTower.notify(this, "afterLand")
    }

    fun notifyBeforeLiftOff() {
        controlTower.notify(this, "beforeLiftOff")
    }

    fun notifyAfterLiftOff() {
        controlTower.notify(this, "afterLiftOff")
    }
}