import unittest
from patterns.structural.composite import ContainerComposite
from patterns.structural.composite import TextComponent
from patterns.structural.composite import UIComponent


class ComponentMock(UIComponent):
    def __init__(self) -> None:
        super().__init__()
        self._was_called = False

    def render(self) -> str:
        self._was_called = True
        return ""

    def has_been_called(self) -> bool:
        return self._was_called


class CompositeTest(unittest.TestCase):
    def test_should_call_component_render_when_container_render(self):
        child = ComponentMock()
        ContainerComposite(child).render()
        self.assertTrue(child.has_been_called())

    def test_should_contain_child_text_msg_when_render_container_is_called(
            self):
        child = TextComponent('test')
        ui = ContainerComposite(child).render()
        self.assertTrue(ui.count(child.get_message()))
