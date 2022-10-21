package design.pattern.kotlin.patterns.structural.proxy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProxyTestKt {
    internal inner class ServiceMock(private val service: Service) : Service {
        private var wasCalled = false
        private var times = 0
        override fun addPrefix(word: String): String {
            wasCalled = true
            times++
            return service.addPrefix(word)
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }

        fun hasBeenCalledTimes(num: Int): Boolean {
            return times == num
        }
    }

    @Test
    fun testShouldCallServiceWhenSameMethodProxyIsCalled() {
        val mock: ServiceMock = ServiceMock(AddCustomPrefix(""))
        val proxy = ServiceProxy(mock)
        proxy.addPrefix("word")
        Assertions.assertTrue(mock.hasBeenCalled())
    }

    @Test
    fun testShouldCallService1WhenMthIsCalledMultTimes() {
        val mock: ServiceMock = ServiceMock(AddCustomPrefix("-"))
        val proxy = ServiceProxy(mock)
        proxy.addPrefix("1")
        proxy.addPrefix("1")
        proxy.addPrefix("1")
        Assertions.assertTrue(mock.hasBeenCalledTimes(1))
    }

    @Test
    fun testShouldReturnCachedValueWhenSameParamIsSent() {
        val service = AddCustomPrefix("")
        val proxy = ServiceProxy(service)
        val first = proxy.addPrefix("word")
        val second = proxy.addPrefix("word")
        val third = proxy.addPrefix("word")
        Assertions.assertTrue(first === second && second === third)
    }
}
