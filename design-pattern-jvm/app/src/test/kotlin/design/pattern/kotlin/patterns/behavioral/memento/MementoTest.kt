package design.pattern.kotlin.patterns.behavioral.memento

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MementoTestKt {
    @Test
    fun shouldReturnToPrevStateWhenUndoIsCalled() {
        val textEditor = TextEditor()
        val expected1 = "hola "
        val expected2 = "mundo"
        val obtained1 = textEditor.write(expected1).write(expected2).printText()
        val obtained2 = textEditor.undo().printText()
        Assertions.assertEquals(expected1 + expected2, obtained1)
        Assertions.assertEquals(expected1, obtained2)
    }
}
