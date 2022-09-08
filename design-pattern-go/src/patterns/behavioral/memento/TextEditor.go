package memento

type TextEditor struct {
	textEditor *TextEditorOriginator
	history    []TextEditorSnapshot
}

func NewTextEditor() *TextEditor {
	return &TextEditor{
		textEditor: NewTextEditorOriginator(),
		history:    []TextEditorSnapshot{},
	}
}

func (te *TextEditor) PrintText() string {
	return te.textEditor.state
}

func (te *TextEditor) Write(text string) *TextEditor {
	te.history = append(te.history, te.textEditor.Save())
	te.textEditor.Write(text)
	return te
}

func (te *TextEditor) Undo() *TextEditor {
	if len(te.history) <= 0 {
		return te
	}
	te.textEditor.Restore(&te.history[len(te.history)-1])
	te.history = te.history[0 : len(te.history)-1]
	return te
}
