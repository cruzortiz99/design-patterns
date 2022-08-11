import unittest
from patterns.behavioral.chain_resposibility import Container, Leaf


class ChainOfResponsibility(unittest.TestCase):
    def test_should_handler_be_called_when_handle_is_called(self):
        was_called = False

        def testHandler():
            nonlocal was_called
            was_called = True
        child = Leaf(testHandler)
        child.handle()
        self.assertTrue(was_called)

    def test_should_call_parent_handler_when_no_handle_is_set_but_called(self):
        was_called = False

        def testHandler():
            nonlocal was_called
            was_called = True
        child = Leaf(None)
        parent = Container(testHandler)
        parent.add(child)
        child.handle()
        self.assertTrue(was_called)

    def test_should_call_the_higher_parent_handler_method_when_none_is_set(
            self):
        was_called = False

        def testHandler():
            nonlocal was_called
            was_called = True
        child = Leaf(None)
        lower_parent = Container(None)
        higher_parent = Container(testHandler)
        higher_parent.add(lower_parent)
        lower_parent.add(child)
        child.handle()
        self.assertTrue(was_called)
