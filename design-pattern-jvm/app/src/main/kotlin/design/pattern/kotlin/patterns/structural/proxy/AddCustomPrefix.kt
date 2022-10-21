package design.pattern.kotlin.patterns.structural.proxy

class AddCustomPrefix(private val prefix: String) : Service {
    override fun addPrefix(word: String): String {
        return prefix + word
    }
}