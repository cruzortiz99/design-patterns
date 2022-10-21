package design.pattern.kotlin.patterns.behavioral.chain_responsibility

import java.util.function.Supplier

open class Leaf(private val handler: Supplier<Boolean>?) : ComponentWithHandler {
    private var container: Container? =
        null

    override fun handle() {
        if (handler != null) {
            handler.get()
        } else if (container != null) {
            container!!.handle()
        }
    }

    fun setContainer(container: Container?) {
        this.container = container
    }
}