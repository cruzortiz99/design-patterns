package design.pattern.java.patterns.behavioral.memento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MementoTest {
  @Test
  public void shouldReturnToPrevStateWhenUndoIsCalled() {
    TextEditor textEditor = new TextEditor();
    String expected1 = "hola ";
    String expected2 = "mundo";
    String obtained1 = textEditor.write(expected1).write(expected2).printText();
    String obtained2 = textEditor.undo().printText();
    Assertions.assertEquals(expected1 + expected2, obtained1);
    Assertions.assertEquals(expected1, obtained2);
  }
}
