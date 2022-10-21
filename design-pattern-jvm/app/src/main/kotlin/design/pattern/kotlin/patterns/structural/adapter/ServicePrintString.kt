package design.pattern.kotlin.patterns.structural.adapter

import java.util.function.Function

class ServicePrintString : Function<String, String> {
    override fun apply(t: String): String {
        return "From Service received: $t"
    }
}