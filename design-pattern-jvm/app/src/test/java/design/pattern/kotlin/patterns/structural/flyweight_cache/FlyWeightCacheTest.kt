package design.pattern.kotlin.patterns.structural.flyweight_cache

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class FlyWeightCacheTest {
    internal inner class ColorShapeMock(color: String, shape: String) : ColorShape(color, shape) {
        private var wasCalled: Boolean? = null
        override fun move(context: Particle, x: Number, y: Number): Particle {
            wasCalled = true
            return super.move(context, x, y)
        }

        fun hasBeenCalled(): Boolean? {
            return wasCalled
        }
    }

    @Test
    fun shouldReturnUniqueColorShapeWhenIsNotCached() {
        val uniqueState = ColorShape("red", "circle")
        val particle = Particle(1, 1, uniqueState)
        Assertions.assertTrue(particle.colorShape === uniqueState)
    }

    @Test
    fun shouldReturnCachedColorShapeWhenIsCached() {
        val uniqueState = ColorShape("red", "circle")
        val cachedState = ColorShape("red", "circle")
        Particle(1, 1, uniqueState)
        val particle2 = Particle(2, 2, cachedState)
        Assertions.assertTrue(particle2.colorShape !== uniqueState)
    }

    @Test
    fun shouldCallCachedMethodWhenContextMethodIsCalled() {
        val uniqueState = ColorShapeMock("red", "circle")
        val particle = Particle(3, 3, uniqueState)
        particle.move(3, 3)
        Assertions.assertTrue(uniqueState.hasBeenCalled()!!)
    }
}