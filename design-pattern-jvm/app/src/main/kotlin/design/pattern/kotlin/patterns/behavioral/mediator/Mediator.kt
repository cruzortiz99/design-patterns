package design.pattern.kotlin.patterns.behavioral.mediator

interface Mediator {
    fun notify(airship: Airship, event: String): String
}