package design.pattern.kotlin.patterns.behavioral.iterator

interface Producer<T> {
    fun hasNext(): Boolean
    operator fun next(): T
}