package design.pattern.kotlin.patterns.behavioral.mediator

open class ControlTower : Mediator {
    override fun notify(airship: Airship, event: String): String {
        return when (event) {
            "beforeLand" -> "preparing to land"
            "afterLand" -> "preparing for passengers boarding"
            "afterLiftOff" -> "cleaning up route to other airship"
            else -> "preparing route to lift off"
        }
    }
}