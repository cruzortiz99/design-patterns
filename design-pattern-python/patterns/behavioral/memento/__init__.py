from typing import List

from numpy import append


class TextEditorMemento:
    def get_text(self) -> str:
        raise Exception("Unimplemented method")


class TextEditorSnapshot(TextEditorMemento):
    def __init__(self, initial_value: str = "") -> None:
        self.__state = initial_value

    def get_text(self) -> str:
        return self.__state


class TextEditorOriginator:
    def __init__(self, initial_value: str = "") -> None:
        self.__state = initial_value

    def save(self) -> TextEditorSnapshot:
        return TextEditorSnapshot(self.__state)

    def restore(self, prev: TextEditorMemento):
        self.__state = prev.get_text()

    def write(self, text: str) -> 'TextEditorOriginator':
        self.__state += text
        return self

    def clear_all(self) -> 'TextEditorOriginator':
        self.__state = ""
        return self

    def get_state(self) -> str:
        return self.__state


class TextEditor:
    def __init__(self) -> None:
        self.text_editor = TextEditorOriginator()
        self.history: List[TextEditorSnapshot] = []

    def print_text(self) -> str:
        return self.text_editor.get_state()

    def write(self, text: str) -> 'TextEditor':
        self.history = append(self.history, self.text_editor.save())
        self.text_editor.write(text)
        return self

    def undo(self) -> 'TextEditor':
        if len(self.history) <= 0:
            return self
        self.text_editor.restore(self.history[len(self.history)-1])
        self.history = self.history[0:len(self.history)-1]
        return self
