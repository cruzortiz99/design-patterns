package design.pattern.kotlin.patterns.structural.decorator

open class LoggerDecorator(private val service: ServiceInterface) : ServiceInterface {
    override fun run(value: String): String {
        log(value)
        return service.run(value)
    }

    internal open fun log(value: String) {
        println("Logging: $value")
    }
}