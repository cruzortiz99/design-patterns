package design.pattern.kotlin.patterns.structural.composite
class ContainerComposite(component: UIComponent) : UIComponent {
    private val children: MutableList<UIComponent> = mutableListOf()
    init {
        children.add(component)
    }
    override fun render(): String {
        return children.stream()
            .map { component: UIComponent -> component.render() }
            .reduce(
                ""
            ) { acc: String, current: String -> "$acc $current" }
    }

    fun add(component: UIComponent): ContainerComposite {
        children.add(component)
        return this
    }

    fun remove(component: UIComponent) {
        children.remove(component)
    }


}