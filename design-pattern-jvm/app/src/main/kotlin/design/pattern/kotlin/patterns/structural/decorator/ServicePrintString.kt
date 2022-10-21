package design.pattern.kotlin.patterns.structural.decorator

open class ServicePrintString : ServiceInterface {
    override fun run(value: String): String {
        return "Printing: $value"
    }
}