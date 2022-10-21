package design.pattern.kotlin.patterns.structural.composite

class TextComponent(val message: String) : UIComponent {
    override fun render(): String {
        return message
    }
}