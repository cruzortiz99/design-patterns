package design.pattern.kotlin.patterns.structural.bridge

class ServiceBridge(private val someLibrary: SomeLibrary) {
    fun concreteFeature(): String {
        return someLibrary.writeString() + someLibrary.writeOtherString() +
                someLibrary.integerGenerator().toString()
    }
}