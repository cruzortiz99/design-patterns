package memento

import (
	"design_patterns_training/patterns/behavioral/memento"
	"testing"
)

func TestShouldReturnToPreviousStateWhenUndoIsCalled(t *testing.T) {
	var textEditor = memento.NewTextEditor()
	var expected1 = "hola "
	var expected2 = "mundo"
	var obtained1 = textEditor.Write(expected1).Write(expected2).PrintText()
	var obtained2 = textEditor.Undo().PrintText()
	if obtained1 != expected1+expected2 {
		t.Fatalf("State was not updated \n\t expected: %v \n\t obtained: %v\n",
			expected1+expected2,
			obtained1)
	}
	if obtained2 != expected1 {
		t.Fatalf("State was not undo \n\t expected: %v \n\t obtained: %v",
			expected1,
			obtained2)
	}
}
