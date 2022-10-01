import unittest

from patterns.behavioral.memento import TextEditor


class MementoTest(unittest.TestCase):
    def test_should_return_to_prev_state_when_undo_is_called(self):
        text_editor = TextEditor()
        expected1 = "hola "
        expected2 = "mundo"
        obtained1 = text_editor.write(expected1).write(expected2).print_text()
        obtained2 = text_editor.undo().print_text()
        self.assertEqual(obtained1, expected1+expected2)
        self.assertEqual(obtained2, expected1)
