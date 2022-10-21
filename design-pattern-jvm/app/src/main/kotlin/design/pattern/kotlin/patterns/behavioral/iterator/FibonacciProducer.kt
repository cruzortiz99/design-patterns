package design.pattern.kotlin.patterns.behavioral.iterator

import java.lang.IndexOutOfBoundsException

class FibonacciProducer : Producer<Int> {
    private var index = 0
    private var current = 1
    private var prev = 0
    override fun hasNext(): Boolean {
        return index < 10
    }

    override fun next(): Int {
        if (!hasNext()) {
            throw IndexOutOfBoundsException()
        }
        current += prev
        prev = current - prev
        index += 1
        return current
    }

    companion object {
        fun create(): Producer<Int> {
            return FibonacciProducer()
        }
    }
}