package design.pattern.kotlin.patterns.behavioral.command

open class Service {
    open fun apply(value: String?) {
        println(value)
    }
}