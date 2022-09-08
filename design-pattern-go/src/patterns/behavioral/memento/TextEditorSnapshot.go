package memento

type TextEditorSnapshot struct {
	state string
}

func NewTextEditorSnapshot(text string) TextEditorSnapshot {
	return TextEditorSnapshot{state: text}
}

func (sn *TextEditorSnapshot) GetText() string {
	return sn.state
}
