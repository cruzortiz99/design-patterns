package design.pattern.kotlin.patterns.structural.decorator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DecoratorTestKt {
    internal inner class DecoratorMock(service: ServiceInterface) : LoggerDecorator(service) {
        private var wasCalled = false
        override fun log(value: String) {
            wasCalled = true
            super.log(value)
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }
    }

    internal inner class ServiceMock : ServicePrintString() {
        private var wasCalled = false
        override fun run(value: String): String {
            wasCalled = true
            return super.run(value)
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }
    }

    @Test
    fun shouldCallTheExtraMethod() {
        val service = ServicePrintString()
        val mock = DecoratorMock(service)
        mock.run("some value")
        Assertions.assertTrue(mock.hasBeenCalled())
    }

    @Test
    fun shouldCallWrappedMethod() {
        val service: ServiceMock = ServiceMock()
        DecoratorMock(service).run("test")
        Assertions.assertTrue(service.hasBeenCalled())
    }
}
