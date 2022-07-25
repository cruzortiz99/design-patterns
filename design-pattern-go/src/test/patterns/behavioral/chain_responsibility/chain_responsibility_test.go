package chainresponsibility

import (
	chainresponsibility "design_patterns_training/patterns/behavioral/chain_responsibility"
	"testing"
)

func TestShouldHandlerBeCalledWhenHandleIsCalled(
	t *testing.T) {
	var wasCalled = false
	var child = chainresponsibility.NewLeaf(func() {
		wasCalled = true
	})
	child.Handle()
	if !wasCalled {
		t.Fatal("Handler was not called")
	}
}
func TestShouldCallParentHandlerWhenNoHandleIsSetButCalled(
	t *testing.T) {
	var wasCalled = false
	var child = chainresponsibility.NewLeaf(nil)
	var parent = chainresponsibility.NewContainer(func() {
		wasCalled = true
	})
	parent.Add(&child)
	child.Handle()
	if !wasCalled {
		t.Fatal("Handler was not called")
	}
}
func TestShouldCallTheHigherParentHandlerMethodWhenNoOneIsSet(
	t *testing.T) {
	var wasCalled = false
	var lowerChild = chainresponsibility.NewLeaf(nil)
	var lowerParent = chainresponsibility.NewContainer(nil)
	var higherParent = chainresponsibility.NewContainer(func() {
		wasCalled = true
	})
	higherParent.Add(&lowerParent.Leaf)
	lowerParent.Add(&lowerChild)
	lowerChild.Handle()
	if !wasCalled {
		t.Fatal("Handle was not called")
	}
}
