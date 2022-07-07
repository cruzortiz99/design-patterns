package composite

import (
	"design_patterns_training/patterns/structural/composite"
	"strings"
	"testing"
)

type ComponentMock struct {
	wasCalled bool
	composite.UIComponent
}

func NewComponentMock() ComponentMock {
	return ComponentMock{wasCalled: false}
}
func (m *ComponentMock) Render() string {
	m.wasCalled = true
	return ""
}
func (m *ComponentMock) HasBeenCalled() bool {
	return m.wasCalled
}

func TestShouldCallComponentRenderWhenContainerRender(t *testing.T) {
	child := NewComponentMock()
	composite.NewContainerComponent(&child).Render()
	if !child.HasBeenCalled() {
		t.Fatal("Component render was not Called")
	}
}
func TestShouldContainChildTexMsgWhenRenderContainerIsCalled(t *testing.T) {
	child := composite.NewTextComponent("test")
	ui := composite.NewContainerComponent(child).Render()
	if !strings.Contains(ui, child.GetMessage()) {
		t.Fatalf("Should contains child msg, received: %v", ui)
	}
}
