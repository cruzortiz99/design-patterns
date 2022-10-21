package design.pattern.kotlin.patterns.behavioral.chain_responsibility

import java.util.function.Supplier

class Container(handler: Supplier<Boolean>?) : Leaf(handler) {
    fun add(leaf: Leaf): Container {
        leaf.setContainer(this)
        return this
    }
}