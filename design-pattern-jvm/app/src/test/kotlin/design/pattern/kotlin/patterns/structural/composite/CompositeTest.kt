package design.pattern.kotlin.patterns.structural.composite

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CompositeTestKt {
    internal inner class ComponentMock : UIComponent {
        private var wasCalled = false
        override fun render(): String {
            wasCalled = true
            return ""
        }

        fun hasBeenCalled(): Boolean {
            return wasCalled
        }
    }

    @Test
    fun shouldCallComponentRenderWhenContainerRender() {
        val child = ComponentMock()
        ContainerComposite(child).render()
        Assertions.assertTrue(child.hasBeenCalled())
    }

    @Test
    fun shouldContainChildTextMsgWhenRenderContainerIsCalled() {
        val child = TextComponent("test")
        val ui = ContainerComposite(child).render()
        Assertions.assertTrue(ui.contains(child.message))
    }
}
