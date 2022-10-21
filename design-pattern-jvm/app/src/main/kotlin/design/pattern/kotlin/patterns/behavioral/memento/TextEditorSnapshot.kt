package design.pattern.kotlin.patterns.behavioral.memento

internal class TextEditorSnapshot(initialValue: String?) : TextEditorMemento {
    override val text: String

    init {
        text = initialValue ?: ""
    }
}