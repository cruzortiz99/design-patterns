package design.pattern.kotlin.patterns.behavioral.chain_responsibility

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ChainResponsibilityTest {
    internal inner class ValueWrapper(private var wasCalled: Boolean) {
        fun setValue(value: Boolean) {
            wasCalled = value
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }
    }

    @Test
    fun shouldHandlerBeCalledWhenHandleIsCalled() {
        val wasCalled: ValueWrapper = ValueWrapper(false)
        val child = Leaf {
            wasCalled.setValue(true)
            true
        }
        child.handle()
        Assertions.assertTrue(wasCalled.hasBeenCalled())
    }

    @Test
    fun shouldCallParentHandlerWhenNoHandleIsSetButCalled() {
        val wasCalled: ValueWrapper = ValueWrapper(false)
        val child = Leaf(null)
        val parent = Container {
            wasCalled.setValue(true)
            true
        }
        parent.add(child)
        child.handle()
        Assertions.assertTrue(wasCalled.hasBeenCalled())
    }

    @Test
    fun shouldCallTheHigherParentHandlerMethodWhenNoneIsSer() {
        val wasCalled: ValueWrapper = ValueWrapper(false)
        val child = Leaf(null)
        val lowerParent = Container(null)
        val higherParent = Container {
            wasCalled.setValue(true)
            true
        }
        higherParent.add(lowerParent)
        lowerParent.add(child)
        child.handle()
        Assertions.assertTrue(wasCalled.hasBeenCalled())
    }
}