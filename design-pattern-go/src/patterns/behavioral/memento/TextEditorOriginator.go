package memento

type TextEditorOriginator struct {
	state string
}

func NewTextEditorOriginator() *TextEditorOriginator {
	return &TextEditorOriginator{state: ""}
}

func (te *TextEditorOriginator) Save() TextEditorSnapshot {
	return NewTextEditorSnapshot(te.state)
}
func (te *TextEditorOriginator) Restore(prev TextEditorMomento) {
	te.state = prev.GetText()
}

func (te *TextEditorOriginator) Write(text string) *TextEditorOriginator {
	te.state += text
	return te
}

func (te *TextEditorOriginator) ClearAll() *TextEditorOriginator {
	te.state = ""
	return te
}
func (te *TextEditorOriginator) GetState() string {
	return te.state
}
