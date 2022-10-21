package design.pattern.kotlin.patterns.structural.bridge

open class SomeLibrary {
    open fun writeString(): String {
        return "String wrote"
    }

    open fun integerGenerator(): Int {
        return (Math.random() * 100).toInt()
    }

    open fun writeOtherString(): String {
        return "Other string wrote"
    }
}