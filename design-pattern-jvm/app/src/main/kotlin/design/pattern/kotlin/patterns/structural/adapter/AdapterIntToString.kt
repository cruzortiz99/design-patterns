package design.pattern.kotlin.patterns.structural.adapter

import java.util.function.Function

class AdapterIntToString(private val service: Function<String, String>) : Function<Int, String> {
    override fun apply(input: Int): String {
        return service.apply(input.toString())
    }
}