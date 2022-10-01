package design.pattern.java.patterns.behavioral.memento;

class TextEditorOriginator {
  private String state;

  public TextEditorOriginator() {
    this.state = "";
  }

  public TextEditorOriginator(String initialValue) {
    this.state = initialValue == null ? "" : initialValue;
  }

  public TextEditorSnapshot save() {
    return new TextEditorSnapshot(this.state);
  }

  public void restore(TextEditorMemento prev) {
    this.state = prev.getText();
  }

  public TextEditorOriginator write(String value) {
    this.state += value;
    return this;
  }

  public TextEditorOriginator clearAll() {
    this.state = "";
    return this;
  }

  public String getState() {
    return this.state;
  }
}