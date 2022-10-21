package design.pattern.kotlin.patterns.behavioral.command

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CommandTestKt {
    internal inner class ServiceMock : Service() {
        private var wasCalled = false
        override fun apply(value: String?) {
            wasCalled = true
            super.apply(value)
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }
    }

    @Test
    fun shouldCallMethodWhenCommandExecutes() {
        val testSrv: ServiceMock = ServiceMock()
        val testCommand = ServiceCommandBuilder(testSrv)
        testCommand.setArgs("value").Run()
        Assertions.assertTrue(testSrv.hasBeenCalled())
    }
}
