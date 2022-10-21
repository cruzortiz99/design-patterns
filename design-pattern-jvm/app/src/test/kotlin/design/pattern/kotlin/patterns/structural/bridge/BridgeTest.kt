package design.pattern.kotlin.patterns.structural.bridge

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BridgeTestKt {
    internal inner class SomeLibraryMock : SomeLibrary() {
        override fun writeString(): String {
            return "writeString"
        }

        override fun writeOtherString(): String {
            return "writeOtherString"
        }

        override fun integerGenerator(): Int {
            return 5
        }
    }

    @Test
    fun shouldCallLibraryMethodsWhenBridgeFeatureIsCalled() {
        val someLibraryMock: SomeLibrary = SomeLibraryMock()
        val bridge = ServiceBridge(someLibraryMock)
        val result = bridge.concreteFeature()
        Assertions.assertTrue(result.contains(someLibraryMock.writeString()))
        Assertions.assertTrue(result.contains(someLibraryMock.writeOtherString()))
        Assertions.assertTrue(result.contains(someLibraryMock.integerGenerator().toString()))
    }
}
