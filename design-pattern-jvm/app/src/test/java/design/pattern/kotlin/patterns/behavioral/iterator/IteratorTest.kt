package design.pattern.kotlin.patterns.behavioral.iterator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class IteratorTest {
    @Test
    fun shouldProduceFibonacciSequenceWhenNextIsCalled() {
        val fbProducer: Producer<Int> = FibonacciProducer()
        var current = 1
        var prev = 0
        while (fbProducer.hasNext()) {
            val obtained = fbProducer.next()
            Assertions.assertEquals(current + prev, obtained)
            current += prev
            prev = current - prev
        }
    }

    @Test
    fun shouldThrowExceptionWhenIndexOutOfBound() {
        val fbProducer: Producer<Int> = FibonacciProducer()
        while (fbProducer.hasNext()) {
            fbProducer.next()
        }
        try {
            fbProducer.next()
            Assertions.fail<Any>("Must throw index out of bound exception")
        } catch (e: IndexOutOfBoundsException) {
            Assertions.assertTrue(true)
        } catch (e: Exception) {
            Assertions.fail<Any>("Must throw index out of bound exception")
        }
    }
}