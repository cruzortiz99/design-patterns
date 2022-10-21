package design.pattern.kotlin.patterns.behavioral.memento

internal class TextEditorOriginator {
    var state: String
        private set

    constructor() {
        state = ""
    }

    constructor(initialValue: String?) {
        state = initialValue ?: ""
    }

    fun save(): TextEditorSnapshot {
        return TextEditorSnapshot(state)
    }

    fun restore(prev: TextEditorMemento) {
        state = prev.text
    }

    fun write(value: String): TextEditorOriginator {
        state += value
        return this
    }

    fun clearAll(): TextEditorOriginator {
        state = ""
        return this
    }
}