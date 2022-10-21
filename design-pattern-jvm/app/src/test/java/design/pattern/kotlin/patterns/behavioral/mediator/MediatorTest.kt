package design.pattern.kotlin.patterns.behavioral.mediator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class MediatorTest {
    internal inner class MockControlTower : ControlTower() {
        private var wasCalled = false
        private var args = ""
        override fun notify(airship: Airship, event: String): String {
            wasCalled = true
            args = event
            return super.notify(airship, event)
        }

        fun hasBeenCalledWith(expected: String): Boolean {
            return wasCalled && args == expected
        }
    }

    @Test
    fun should_call_notify_when_airship_emits_event() {
        val ct = MockControlTower()
        Airship(ct).notifyBeforeLand()
        Assertions.assertTrue(ct.hasBeenCalledWith("beforeLand"))
    }
}