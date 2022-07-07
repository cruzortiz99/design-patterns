package design.pattern.java.patterns.structural.composite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompositeTest {
    class ComponentMock implements UIComponent {
        private Boolean wasCalled;
        public ComponentMock() {
            this.wasCalled = false;
        }
        @Override
        public String render() {
            this.wasCalled = true;
            return "";
        }
        public Boolean hasBeenCalled() {
            return this.wasCalled;
        }

    }
    @Test
    public void shouldCallComponentRenderWhenContainerRender() {
        ComponentMock child = new ComponentMock();
        new ContainerComposite(child).render();
        Assertions.assertTrue(child.hasBeenCalled());
    }
    @Test
    public void shouldContainChildTextMsgWhenRenderContainerIsCalled() {
        TextComponent child = new TextComponent("test");
        String ui = new ContainerComposite(child).render();
        Assertions.assertTrue(ui.contains(child.getMessage()));
    }
}
