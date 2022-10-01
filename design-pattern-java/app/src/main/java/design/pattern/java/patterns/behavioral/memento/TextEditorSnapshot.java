package design.pattern.java.patterns.behavioral.memento;

class TextEditorSnapshot implements TextEditorMemento {

  private String state;

  public TextEditorSnapshot(String initialValue) {
    this.state = initialValue == null ? "" : initialValue;
  }

  @Override
  public String getText() {
    return this.state;
  }
}