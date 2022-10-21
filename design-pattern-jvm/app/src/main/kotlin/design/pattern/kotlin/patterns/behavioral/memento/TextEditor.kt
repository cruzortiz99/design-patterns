package design.pattern.kotlin.patterns.behavioral.memento

/**
 * Memento Pattern Package Example
 */
class TextEditor {
    private val textEditor: TextEditorOriginator = TextEditorOriginator()
    private var history: MutableList<TextEditorSnapshot>
    fun printText(): String {
        return textEditor.state
    }

    fun write(value: String?): TextEditor {
        history.add(textEditor.save())
        textEditor.write(value!!)
        return this
    }

    fun undo(): TextEditor {
        if (history.size <= 0) return this
        textEditor.restore(history[history.size - 1])
        history = history.subList(0, history.size - 1)
        return this
    }

    init {
        history = mutableListOf()
    }
}