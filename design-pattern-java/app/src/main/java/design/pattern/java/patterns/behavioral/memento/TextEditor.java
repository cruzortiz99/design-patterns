package design.pattern.java.patterns.behavioral.memento;

/**
 * Memento Pattern Package Example
 */
public class TextEditor {
  private TextEditorOriginator textEditor;
  private java.util.List<TextEditorSnapshot> history;

  public TextEditor() {
    this.textEditor = new TextEditorOriginator();
    this.history = new java.util.ArrayList<>();
  }

  public String printText() {
    return this.textEditor.getState();
  }

  public TextEditor write(String value) {
    this.history.add(this.textEditor.save());
    this.textEditor.write(value);
    return this;
  }

  public TextEditor undo() {
    if (this.history.size() <= 0)
      return this;
    this.textEditor.restore(this.history.get(this.history.size() - 1));
    this.history = this.history.subList(0, this.history.size() - 1);
    return this;
  }
}
